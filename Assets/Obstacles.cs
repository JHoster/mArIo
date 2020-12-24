using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Obstacles : MonoBehaviour
{
    public float delta = 1.5f;
    public float speed = 2.0f;
    private Vector3 startPos;
    public bool vertical;
    private float t;
    private float tnew;

    void Start()
    {
        startPos = transform.position;
        tnew = 0;
    }

    void Update()
    {
        t = Time.time - tnew;
        Vector3 v = startPos;
        if (vertical)
            v.y += delta * Mathf.Sin(t * speed);
        else
            v.x += delta * Mathf.Sin(t * speed);
        transform.position = v;
    }

    public void reset()
    {
        tnew = Time.time;
        transform.position = startPos;
    }
}
