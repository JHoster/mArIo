using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Linq;

public class PopulationManager : MonoBehaviour
{
    public GameObject botPrefab;
    public int populationSize = 50;
    List<GameObject> population = new List<GameObject>();
    public static int populationAlive;
    public static float elapsed = 0;
    public float trialTime = 5;
    public bool trials;
    int generation = 1;
    public static Transform startPos;

    GUIStyle guiStyle = new GUIStyle();
    private void OnGUI()
    {
        guiStyle.fontSize = 25;
        guiStyle.normal.textColor = Color.white;
        GUI.BeginGroup(new Rect(10, 10, 250, 150));
        GUI.Box(new Rect(0, 0, 140, 140), "Stats", guiStyle);
        GUI.Box(new Rect(10, 25, 200, 30), "Gen: " + generation, guiStyle);
        GUI.Box(new Rect(10, 50, 200, 30), string.Format("Time: {0:0.00}", elapsed), guiStyle);
        GUI.Box(new Rect(10, 75, 200, 30), "Bots still alive: " + populationAlive, guiStyle);
        GUI.EndGroup();
    }

    private void Start()
    {
        startPos = transform;
        for (int i = 0; i < populationSize; i++)
        {
            GameObject b = Instantiate(botPrefab, startPos.position, startPos.rotation);
            b.GetComponent<Brain>().Init();
            population.Add(b);
        }
        populationAlive = population.Count;
    }

    GameObject Breed(GameObject parent1, GameObject parent2)
    {
        GameObject offspring = Instantiate(botPrefab, startPos.position, startPos.rotation);
        Brain b = offspring.GetComponent<Brain>();
        if (Random.Range(0, 100) == 1) // mutate 1 in 100
        {
            b.Init();
            b.dna.Mutate();
        }
        else
        {
            b.Init();
            b.dna.Combine(parent1.GetComponent<Brain>().dna, parent2.GetComponent<Brain>().dna);
        }
        return offspring;

    }

    public void BreedNewPopulation() //Fitness 
    {
        //List<GameObject> sortedList = population.OrderBy(o => o.GetComponent<Brain>().timeAlive).ToList(); //Time
        List<GameObject> sortedList = population.OrderBy(o => o.GetComponent<Brain>().distanceTravelled).ToList(); //Distance
        //Crahes?

        population.Clear();
        //breed upper half of sorted list
        for (int i = (int)(sortedList.Count / 2.0f) - 1; i < sortedList.Count - 1; i++)
        {
            population.Add(Breed(sortedList[i], sortedList[i + 1]));
            population.Add(Breed(sortedList[i + 1], sortedList[i]));
        }
        //destroy all parents and previous population
        for (int i = 0; i < sortedList.Count; i++)
        {
            Destroy(sortedList[i]);
        }
        generation++;
        populationAlive = populationSize;
    }

    private void Update()
    {
        elapsed += Time.deltaTime;
        if (elapsed >= trialTime && trials)
        {
            BreedNewPopulation();
            elapsed = 0;
        }
    }
}