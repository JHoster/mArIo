using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cam : MonoBehaviour
{
    public GameObject target;
    Vector3 offset;

    private void Start()
    {
        offset = transform.position;
    }

    void Update()
    {
        transform.position = Vector3.Lerp(transform.position, new Vector3(target.transform.position.x,0,0) + offset, 0.1f);
    }
}