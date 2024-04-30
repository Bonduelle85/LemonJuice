package com.example.lemonjuice

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class HintTextViewUi(
    rootId: Int,
    parent: Matcher<View>,
) {

    private val hintTextTree: Int = R.string.click_pick
    private val hintTextLemonBefore:Int = R.string.click_lemon
    private val hintTextLemonAfter:Int = R.string.click_squeeze
    private val hintTextJuice: Int = R.string.click_drink
    private val hintTextFinish: Int = R.string.click_again

    private val viewInteraction = onView(Matchers.allOf(
        withId(R.id.hintTextView),
        isAssignableFrom(TextView::class.java),
        parent,
        withParent(withId(rootId)),
    ))

    fun checkStateIsTree() {
        viewInteraction
            .check(matches(withText(hintTextTree)))
    }

    fun checkStateIsLemonBefore() {
        viewInteraction.check(matches(withText(hintTextLemonBefore)))
    }

    fun checkStateIsLemonAfter() {
        viewInteraction.check(matches(withText(hintTextLemonAfter)))
    }

    fun checkStateIsJuice() {
        viewInteraction
            .check(matches(withText(hintTextJuice)))
    }

    fun checkStateIsFinish() {
        viewInteraction
            .check(matches(withText(hintTextFinish)))
    }
}