using UnityEngine;

public class Brain : MonoBehaviour
{
    int DNALength = 4; //decision when seeing: nothing, ground, death, obstacle
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
    private float jumpTimeCounter;
    public float jumpTime;
    private bool isJumping;
    private bool once;
    public LayerMask ignoreMask;
    public static bool botWon = false;

    public void Init()  //initialise DNA
    {
        dna = new DNA(DNALength, 4); //Number of reactions: 0 = no Movement, 1 = moveForward, 2 = don'tJump, 3 = Jump
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
            botWon = true;
            Menu.GameIsOver = true;
        }
    }

    private void OnCollisionExit2D(Collision2D collision)
    {
        if (collision.gameObject.tag == "ground")
            grounded = false;
    }

    private void Update()
    {
        //Check status
        if (crash > Player.crashMax)
            alive = false;

        if (alive)
        {
            distanceTravelled = Vector2.Distance(this.transform.position, PopulationManager.startPos.position);
        }
        else
        {
            if (!once)
            {
                once = true;
                PopulationManager.populationAlive--;
                rb.velocity = new Vector2(0, rb.velocity.y);
                distanceTravelled -= 10; //= distanceTravelled / 2; //(if punishment is too high, bots won't take any risk)
                anim.SetBool("dead", true);
            }
        }

        if (!alive) return;

        //Check surroundings
        seeGround = false;
        seeObstacle = false;
        seeDeath = false;
        RaycastHit2D hit = Physics2D.Raycast(eyes.transform.position, eyes.transform.forward, 30.0f, ~ignoreMask);
        Debug.DrawRay(eyes.transform.position, eyes.transform.forward * 30.0f, Color.red);

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

        //Decision making based on DNA
        float forwardForce = 1;
        bool jump = false;

        if (seeGround)
        {
            if (dna.GetGene(0) == 0) forwardForce = 0;
            else if (dna.GetGene(0) == 1) forwardForce = 1;
            else if (dna.GetGene(0) == 2) jump = false;
            else if (dna.GetGene(0) == 3) jump = true;
        }
        else if (seeObstacle)
        {
            if (dna.GetGene(1) == 0) forwardForce = 0;
            else if (dna.GetGene(1) == 1) forwardForce = 1;
            else if (dna.GetGene(1) == 2) jump = false;
            else if (dna.GetGene(1) == 3) jump = true;
        }
        else if (seeDeath)
        {
            if (dna.GetGene(2) == 0) forwardForce = 0;
            else if (dna.GetGene(2) == 1) forwardForce = 1;
            else if (dna.GetGene(2) == 2) jump = false;
            else if (dna.GetGene(2) == 3) jump = true;
        }
        else
        {
            if (dna.GetGene(3) == 0) forwardForce = 0;
            else if (dna.GetGene(3) == 1) forwardForce = 1;
            else if (dna.GetGene(3) == 2) jump = false;
            else if (dna.GetGene(3) == 3) jump = true;
        }

        //Animation
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

        //Apply movement
        rb.velocity = new Vector2(forwardForce * speed, rb.velocity.y);
    }
}
