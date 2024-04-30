package com.example.lemonjuice

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * TestCase N1: Correct
     *
     * (Состояние дерево).
     * Нажать на pick (состояние “лимон до”)
     * Нажать на лимон (состояние “лимон до”)
     * Нажать на лимон (состояние “лимон до”)
     * Нажать на лимон (состояние “лимон до”)
     * Нажать на лимон (состояние “лимон до”)
     * Нажать на лимон (состояние “лимон после”)
     * нажать “squeeze” (состояние “сок”)
     * нажать на drink (состояние again)
     * нажать на again (состояние дерево)
     * */

    @Test
    fun testCase() {
        val gamePage = GamePage()
        gamePage.checkStateIsTree()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsTree()

        gamePage.clickActionButton()
        gamePage.checkStateIsLemonBefore()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton()
        gamePage.checkStateIsLemonBefore()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton()
        gamePage.checkStateIsLemonBefore()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton()
        gamePage.checkStateIsLemonBefore()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton()
        gamePage.checkStateIsLemonBefore()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton()
        gamePage.checkStateIsLemonAfter()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsLemonAfter()

        gamePage.clickActionButton()
        gamePage.checkStateIsJuice()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsJuice()

        gamePage.clickActionButton()
        gamePage.checkStateIsFinish()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsFinish()

        gamePage.clickActionButton()
        gamePage.checkStateIsTree()
        activityScenarioRule.scenario.recreate()
        gamePage.checkStateIsTree()
    }
}