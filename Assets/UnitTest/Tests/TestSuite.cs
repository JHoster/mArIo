using System.Collections;
using System.Collections.Generic;
using NUnit.Framework;
using UnityEngine;
using UnityEngine.TestTools;

public class TestSuite
{
    private GameObject game;
    private GameObject obs;
    private GameObject bot;

    [UnityTest]
    public IEnumerator GamePausesUntilPlay()
    {
        game = MonoBehaviour.Instantiate(Resources.Load<GameObject>("Game"));
        Assert.True(Menu.GameIsPaused);
        game.transform.Find("Canvas").GetComponent<Menu>().Resume();
        Assert.False(Menu.GameIsPaused);
        yield return null;
    }

    [UnityTest]
    public IEnumerator ObstacleMovesUpAndDown()
    {
        obs = MonoBehaviour.Instantiate(Resources.Load<GameObject>("Obs"));
        float initialYPos = obs.transform.position.y;
        yield return new WaitForSeconds(0.1f);
        Assert.Greater(obs.transform.position.y, initialYPos);
        yield return new WaitForSeconds(0.9f);
        Assert.Less(obs.transform.position.y, initialYPos);
        GameObject.Destroy(obs);
    }

    [UnityTest]
    public IEnumerator OnObstacleCollisionBotDies()
    {
        bot = GameObject.Find("Bot(Clone)");
        obs = MonoBehaviour.Instantiate(Resources.Load<GameObject>("Obs"));
        bot.transform.position = obs.transform.position;
        yield return new WaitForSeconds(1f);
        Assert.Greater(bot.GetComponent<Brain>().crash, Player.crashMax);
    }
}