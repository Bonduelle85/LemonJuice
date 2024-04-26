package com.example.lemonjuice

import android.widget.LinearLayout
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withParent

class GamePage {

    private val rootId: Int = R.id.rootLayout
    private val parent =
        withParent(isAssignableFrom(LinearLayout::class.java))

    private val actionImageButtonUi = ActionImageButtonUi(rootId, parent)
    private val actionButtonUi = ActionButtonUi(rootId, parent)
    private val hintTextViewUi = HintTextViewUi(rootId, parent)

    fun checkStateIsTree() {
        actionImageButtonUi.checkStateIsTree()
        actionButtonUi.checkStateIsTree()
        hintTextViewUi.checkStateIsTree()
    }

    fun checkStateIsLemonBefore() {
        actionImageButtonUi.checkStateIsLemonBefore()
        actionButtonUi.checkStateIsLemonBefore()
        hintTextViewUi.checkStateIsLemonBefore()
    }

    fun checkStateIsLemonAfter() {
        actionImageButtonUi.checkStateIsLemonAfter()
        actionButtonUi.checkStateIsLemonAfter()
        hintTextViewUi.checkStateIsLemonAfter()
    }

    fun checkStateIsJuice() {
        actionImageButtonUi.checkStateIsJuice()
        actionButtonUi.checkStateIsJuice()
        hintTextViewUi.checkStateIsJuice()
    }

    fun checkStateIsFinish() {
        actionImageButtonUi.checkStateIsFinish()
        actionButtonUi.checkStateIsFinish()
        hintTextViewUi.checkStateIsFinish()
    }

    fun clickActionButton() {
        actionButtonUi.clickActionButton()
    }

    fun clickImageButton() {
        actionImageButtonUi.clickImageButton()
    }
}