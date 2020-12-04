using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Brain : MonoBehaviour
{
    int DNALength = 4; //decision when seeing: nothing, ground, death, obstacle
    public float timeAlive;
    public float distanceTravelled;
    public int crash;
    public DNA dna;
    public GameObject eyes;
    bool seeGround = true;
    bool seeObstacle = false;
    bool seeDeath = false;
    bool alive = true;
    bool grounded = true;
    Rigidbody2D rb;
    Animator anim;

    public float speed;
    public float jumpForce;
    private bool jumped;
    private float jumpTimeCounter;
    public float jumpTime;
    private bool isJumping;

    public LayerMask ignoreMask;

    public void Init()  //initialise DNA
    {
        dna = new DNA(DNALength, 2); //Number of reactions: 2 = don'tJump, 3 = Jump //0 = no Movement, 1 = moveForward, 
        timeAlive = 0;
        alive = true;
        rb = this.GetComponent<Rigidbody2D>();
        anim = this.GetComponent<Animator>();
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "obstacle")
        {
            crash++;
        }
        if (collision.gameObject.tag == "death")
        {
            alive = false;
        }
        if (collision.gameObject.tag == "ground")
        {
            grounded = true;
        }
        if (collision.gameObject.tag == "goal")
        {
            Debug.Log("BOT WON!!!");
        }
    }

    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "ground")
            grounded = false;
    }

    private void Update()
    {
        if (crash > Player.crashMax)
            alive = false;

        if (alive)
            distanceTravelled = Vector2.Distance(this.transform.position, PopulationManager.startPos.position);
        else
        {
            distanceTravelled = 0;
            //GetComponent<CapsuleCollider2D>().enabled = false;
            anim.SetBool("dead", true);
        }

        if (!alive) return;
        timeAlive = PopulationManager.elapsed;

        seeGround = false;
        seeObstacle = false;
        seeDeath = false;
        RaycastHit2D hit = Physics2D.Raycast(eyes.transform.position, eyes.transform.forward, 10.0f, ~ignoreMask);

        Debug.DrawRay(eyes.transform.position, eyes.transform.forward * 10.0f, Color.red);

        if (hit.collider != null)
        {
            if (hit.collider.gameObject.tag == "obstacle")
                seeObstacle = true;
            if (hit.collider.gameObject.tag == "death")
                seeDeath = true;
            if (hit.collider.gameObject.tag == "ground")
                seeGround = true;
        }
        else
        {
            seeGround = false;
            seeObstacle = false;
            seeDeath = false;
        }

        bool jump = false;
        float forwardForce = 1;

        if (seeGround)
        {
            if (dna.GetGene(0) == 0) forwardForce = 0;
            else if (dna.GetGene(0) == 1) forwardForce = 1;
            else if (dna.GetGene(0) == 0) jump = false;
            else if (dna.GetGene(0) == 1) jump = true;
        }
        else if (seeObstacle)
        {
            if (dna.GetGene(1) == 0) forwardForce = 0;
            else if (dna.GetGene(1) == 1) forwardForce = 1;
            else if (dna.GetGene(1) == 0) jump = false;
            else if (dna.GetGene(1) == 1) jump = true;
        }
        else if (seeDeath)
        {
            if (dna.GetGene(2) == 0) forwardForce = 0;
            else if(dna.GetGene(2) == 1) forwardForce = 1;
            else if(dna.GetGene(2) == 0) jump = false;
            else if (dna.GetGene(2) == 1) jump = true;
        }
        else
        {
            if (dna.GetGene(3) == 0) forwardForce = 0;
            else if (dna.GetGene(3) == 1) forwardForce = 1;
            if (dna.GetGene(3) == 0) jump = false;
            else if (dna.GetGene(3) == 1) jump = true;
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
                transform.rotation = Quaternion.Euler(0, 180, 0);
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

        //Jumping
        //if (grounded && jump)
        //{
        //    grounded = false;
        //    rb.AddForce(this.transform.up * jumpForce, ForceMode2D.Impulse);
        //}

        if (jump && grounded)
        {
            grounded = false;
            isJumping = true;
            jumpTimeCounter = jumpTime;
            rb.velocity = Vector2.up * jumpForce;
        }
        if (jump && isJumping)
        {
            if (jumpTimeCounter > 0)
            {
                rb.velocity = Vector2.up * jumpForce;
                jumpTimeCounter -= Time.deltaTime;
            }
            else
                isJumping = false;
        }
        if (!jump)
        {
            isJumping = false;
        }

        //rb.AddForce(this.transform.right * forwardForce * speed);
        rb.velocity = new Vector2(forwardForce * speed, rb.velocity.y);
    }
}
