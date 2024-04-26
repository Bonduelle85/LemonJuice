package com.example.lemonjuice

import android.view.View
import android.widget.ImageButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.core.IsNot.not

class ActionImageButtonUi(
    private val rootId: Int,
    private val parent: Matcher<View>
) {

    private val contentDescriptionTree: Int = R.string.tree
    private val contentDescriptionLemon: Int = R.string.lemon
    private val contentDescriptionJuice: Int = R.string.juice
    private val contentDescriptionEmptyGlass: Int = R.string.empty_glass

    private val viewInteraction = onView(
        Matchers.allOf(
            withId(R.id.actionImageButton),
            isAssignableFrom(ImageButton::class.java),
            parent,
            withParent(withId(rootId)),
        )
    )

    fun checkStateIsTree() {
        viewInteraction.check(matches(withContentDescription(contentDescriptionTree)))
            .check(matches(DrawableMatcher(R.drawable.ic_tree)))
            .check(matches(not(isClickable())))
    }

    fun checkStateIsLemonBefore() {
        viewInteraction.check(matches(withContentDescription(contentDescriptionLemon)))
            .check(matches(DrawableMatcher(R.drawable.ic_lemon)))
            .check(matches(not(isClickable())))
    }

    fun checkStateIsLemonAfter() {
        viewInteraction.check(matches(withContentDescription(contentDescriptionLemon)))
            .check(matches(DrawableMatcher(R.drawable.ic_lemon)))
            .check(matches(not(isClickable())))
    }

    fun checkStateIsJuice() {
        viewInteraction.check(matches(withContentDescription(contentDescriptionJuice)))
            .check(matches(DrawableMatcher(R.drawable.ic_lemon)))
            .check(matches(not(isClickable())))
    }

    fun checkStateIsFinish() {
        viewInteraction.check(matches(withContentDescription(contentDescriptionEmptyGlass)))
            .check(matches(DrawableMatcher(R.drawable.ic_lemon)))
            .check(matches(not(isClickable())))
    }

    fun clickImageButton() {
        viewInteraction.perform(click())
    }
}