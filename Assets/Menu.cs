using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using TMPro;

public class Menu : MonoBehaviour
{
    public static bool GameIsPaused;
    public static bool GameIsOver;
    public GameObject pauseMenuUI;
    public GameObject playButton;
    public GameObject restartButton;
    public TMP_Text won;
    public Slider popSlider;
    public TMP_Text popSizeValueText;
    public static int popSize = 10;

    void Awake()
    {
        playButton.SetActive(true);
        Player.playerWon = false;
        Brain.botWon = false;
        GameIsOver = false;
        GameIsPaused = true;
        Time.timeScale = 0f;
        popSlider.value = popSize;
    }

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.P))
        {
            if (GameIsPaused)
                Resume();
            else
                Pause();
        }
        if (GameIsOver)
        {
            playButton.SetActive(false);
            if (Player.playerWon)
                won.text = "Player won!"; 
            else if(Brain.botWon)
                won.text = "Bot won!";
            else
                won.text = "";
            Pause();
        }
    }

    public void Resume()
    {
        pauseMenuUI.SetActive(false);
        Time.timeScale = 1f;
        GameIsPaused = false;
    }

    public void Pause()
    {
        pauseMenuUI.SetActive(true);
        Time.timeScale = 0f;
        GameIsPaused = true;
    }

    public void Restart()
    {
        Player.playerWon = false;
        Brain.botWon = false;
        GameIsOver = false;
        Application.LoadLevel(Application.loadedLevel);
    }

    public void OnValueChanged(float newValue)
    {
        popSize = (int)newValue;
        popSizeValueText.text = popSize.ToString();
        PopulationManager.populationSize = popSize;
    }
}
