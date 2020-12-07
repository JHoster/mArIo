using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Player : MonoBehaviour
{
    bool grounded = true;
    public float speed;
    public float jumpForce;
    private float moveInput;
    private bool jumped;
    private float jumpTimeCounter;
    public float jumpTime;
    private bool isJumping;
    Rigidbody2D rb;
    Animator anim;
    public GameObject PopManager;
    public int crash;
    public static int crashMax = 1;
    public bool autoRun;

    // Start is called before the first frame update
    void Start()
    {
        rb = this.GetComponent<Rigidbody2D>();
        anim = this.GetComponent<Animator>();
    }

    // Update is called once per frame
    void Update()
    {
        //Bot-similar control:
        //if (Input.GetKeyDown(KeyCode.Space))
        //{
        //    if (grounded)
        //    {
        //        grounded = false;
        //        rb.AddForce(this.transform.up * 100, ForceMode2D.Impulse);
        //    }
        //}
        //if(Input.GetKey(KeyCode.D))
        //    rb.AddForce(this.transform.right * 100);

        if (crash > crashMax)
            dead();

        //Movement
        if (Input.GetKeyDown("space") && grounded)
        {
            grounded = false;
            isJumping = true;
            jumpTimeCounter = jumpTime;
            rb.velocity = Vector2.up * jumpForce;
        }
        if (Input.GetKey("space") && isJumping)
        {
            if (jumpTimeCounter > 0)
            {
                rb.velocity = Vector2.up * jumpForce;
                jumpTimeCounter -= Time.deltaTime;
            }
            else
                isJumping = false;
        }
        if (Input.GetKeyUp("space"))
        {
            isJumping = false;
        }

        //Anim
        if (rb.velocity.y > 0)
        {
            anim.SetBool("jumping", true);
            anim.SetBool("running", false);
            anim.SetBool("falling", false);
        }
        else if (rb.velocity.y < 0)
        {
            anim.SetBool("falling", true);
            anim.SetBool("running", false);
            anim.SetBool("jumping", false);
        }
        else if (rb.velocity.x != 0)
        {
            if (rb.velocity.x > 0)
                transform.rotation = Quaternion.identity;
            if (rb.velocity.x < 0)
                transform.rotation = Quaternion.Euler(0,180,0);
            anim.SetBool("running", true);
            anim.SetBool("falling", false);
            anim.SetBool("jumping", false);
        }
        else
        {
            anim.SetBool("running", false);
            anim.SetBool("falling", false);
            anim.SetBool("jumping", false);
        }
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "death" && gameObject.tag == "Player") //otherwise bots will trigger it
        {
            dead();
        }
        if (collision.gameObject.tag == "obstacle")
        {
            crash++;
        }
        if (collision.gameObject.tag == "ground")
        {
            grounded = true;
        }
        if(collision.gameObject.tag == "goal")
        {
            Debug.Log("PLAYER WON!!!");
        }
    }

    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "ground")
            grounded = false;
    }

    private void FixedUpdate()
    {
        if (!autoRun)
            moveInput = Input.GetAxisRaw("Horizontal");
        else
            moveInput = 1;
        rb.velocity = new Vector2(moveInput * speed, rb.velocity.y);
    }

    private void dead()
    {
        crash = 0;
        gameObject.transform.position = PopulationManager.startPos.position;
        PopulationManager.elapsed = 0;
        PopManager.GetComponent<PopulationManager>().BreedNewPopulation();
        //Application.LoadLevel(Application.loadedLevel);
    }
}
