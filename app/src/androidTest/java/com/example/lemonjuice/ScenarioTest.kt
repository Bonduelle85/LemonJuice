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
    fun caseNumberOne() {
        val gamePage = GamePage()
        gamePage.checkStateIsTree() // Is Tree

        gamePage.clickActionButton()
        gamePage.checkStateIsLemonBefore() // Is Lemon Before

        gamePage.clickImageButton() // 1
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton() // 2
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton() // 3
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton() // 4
        gamePage.checkStateIsLemonBefore()

        gamePage.clickImageButton() // 5
        gamePage.checkStateIsLemonAfter() // Is Lemon After

        gamePage.clickImageButton()
        gamePage.checkStateIsJuice() // IsJuice

        gamePage.clickImageButton()
        gamePage.checkStateIsFinish() // IsAgain

        gamePage.clickImageButton()
        gamePage.checkStateIsTree() // IsTree
    }
}