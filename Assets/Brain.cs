using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Brain : MonoBehaviour
{
    int DNALength = 2; //decision when seeing: nothing, ground //, death, obstacle
    public float timeAlive;
    public float distanceTravelled;
    public int crash;
    public DNA dna;
    public GameObject eyes;
    bool seeGround = true;
    //bool seeObstacle = false;
    //bool seeDeath = false;
    bool alive = true;
    Rigidbody2D rb;

    public void Init()  //initialise DNA
    {
        dna = new DNA(DNALength, 3); //Number of reactions, here: 0 = moveForward, 1 = don'tJump, 2 = Jump
        timeAlive = 0;
        alive = true;
        rb = this.GetComponent<Rigidbody2D>();
    }

    private void OnCollisionEnter2D(Collision2D collision)
    {
        if(collision.gameObject.tag == "obstacle")
        {
            crash++;
        }
        if (collision.gameObject.tag == "death")
        {
            alive = false;
        }
    }

    private void Update()
    {
        if (!alive) return;
        seeGround = false;
        //seeObstacle = false;
        //seeDeath = false;
        RaycastHit2D hit = Physics2D.Raycast(eyes.transform.position, eyes.transform.forward, 10.0f);

        Debug.DrawRay(eyes.transform.position, eyes.transform.forward * 10.0f, Color.red);

        if (hit.collider != null)
        {
            //if (hit.collider.gameObject.tag == "obstacle")
            //    seeObstacle = true;
            //if (hit.collider.gameObject.tag == "death")
            //    seeDeath = true;
            if (hit.collider.gameObject.tag == "ground")
                seeGround = true;
        }
        else
            seeGround = false; //also seeObstacle = false //also seeDeath = false;
        timeAlive = PopulationManager.elapsed;

        float upforce = 0;
        float forwardForce = 0;

        //if (seeObstacle)
        //    upforce = dna.GetGene(0);
        //if (seeDeath)
        //    upforce = dna.GetGene(1);
        if (seeGround)
        {
            if (dna.GetGene(0) == 0) forwardForce = 10;
            else if (dna.GetGene(0) == 1) upforce = 0;
            else if (dna.GetGene(0) == 2) upforce = 1;
        }
        else
        {
            if (dna.GetGene(1) == 0) forwardForce = 10;
            else if (dna.GetGene(1) == 1) upforce = 0;
            else if (dna.GetGene(1) == 2) upforce = 1;
        }

        rb.AddForce(this.transform.right * forwardForce);
        //rb.AddForce(this.transform.up * upforce);
        rb.AddForce(this.transform.up * upforce, ForceMode2D.Impulse); //Jumping needs groundin!

        distanceTravelled = Vector2.Distance(this.transform.position, PopulationManager.startPos.position);
    }
}
