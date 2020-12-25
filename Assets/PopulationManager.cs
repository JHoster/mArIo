using System.Collections.Generic;
using System.Linq;
using UnityEngine;

public class PopulationManager : MonoBehaviour
{
    public GameObject botPrefab;
    public static int populationSize = 10;
    List<GameObject> population = new List<GameObject>();
    public static int populationAlive;
    int generation = 1;
    public static Transform startPos;

    GUIStyle guiStyle = new GUIStyle();
    private void OnGUI()
    {
        guiStyle.fontSize = 25;
        guiStyle.normal.textColor = Color.white;
        GUI.BeginGroup(new Rect(10, 10, 250, 150));
        GUI.Box(new Rect(0, 0, 140, 140), "Stats", guiStyle);
        GUI.Box(new Rect(0, 25, 200, 30), "Gen: " + generation, guiStyle);
        GUI.Box(new Rect(0, 50, 200, 30), "Bots still alive: " + populationAlive, guiStyle);
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

    public void BreedNewPopulation() //based on fitness (distance travelled)
    {
        List<GameObject> sortedList = population.OrderBy(o => o.GetComponent<Brain>().distanceTravelled).ToList();

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
}