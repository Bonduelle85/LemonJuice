package com.example.lemonjuice

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class ActionButtonUi(
    private val rootId: Int,
    private val parent: Matcher<View>,
) {

    private val textPick: Int = R.string.pick
    private val textSqueeze: Int = R.string.squeeze
    private val textDrink: Int = R.string.drink
    private val textAgain: Int = R.string.again

    private val viewInteraction = onView( Matchers.allOf(
        withId(R.id.actionButton),
        isAssignableFrom(AppCompatButton::class.java),
        parent,
        withParent(withId(rootId)),
    ))

    fun checkStateIsTree() {
        viewInteraction.check(matches(ViewMatchers.isClickable()))
            .check(matches(ViewMatchers.withText(textPick)))
            .check(matches(ViewMatchers.isEnabled()))
    }

    fun checkStateIsLemonBefore() {
        viewInteraction.check(matches(ViewMatchers.isNotClickable()))
            .check(matches(ViewMatchers.withText(textSqueeze)))
            .check(matches(Matchers.not(ViewMatchers.isEnabled())))
    }

    fun checkStateIsLemonAfter() {
        viewInteraction.check(matches(ViewMatchers.isClickable()))
            .check(matches(ViewMatchers.withText(textSqueeze)))
            .check(matches(ViewMatchers.isEnabled()))
    }

    fun checkStateIsJuice() {
        viewInteraction.check(matches(ViewMatchers.isClickable()))
            .check(matches(ViewMatchers.withText(textDrink)))
            .check(matches(ViewMatchers.isEnabled()))
    }

    fun checkStateIsFinish() {
        viewInteraction.check(matches(ViewMatchers.isClickable()))
            .check(matches(ViewMatchers.withText(textAgain)))
            .check(matches(ViewMatchers.isEnabled()))
    }

    fun clickActionButton() {
        viewInteraction.perform(click())
    }
}