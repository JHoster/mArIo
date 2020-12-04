using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Obstacles : MonoBehaviour
{
    public float delta = 1.5f;
    public float speed = 2.0f;
    private Vector3 startPos;
    public bool vertical;

    void Start()
    {
        startPos = transform.position;
    }

    void Update()
    {
        Vector3 v = startPos;
        if (vertical)
            v.y += delta * Mathf.Sin(Time.time * speed);
        else
            v.x += delta * Mathf.Sin(Time.time * speed);
        transform.position = v;
    }
}
