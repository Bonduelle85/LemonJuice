package com.example.lemonjuice.views.text

import androidx.annotation.StringRes
import com.example.lemonjuice.R

interface HintTextViewUiState {

    fun show(updateText: UpdateText)

    abstract class Abstract(
        @StringRes private val resId: Int
    ) : HintTextViewUiState {
        override fun show(updateText: UpdateText) {
            updateText.updateText(resId)
        }
    }

    object Tree: Abstract(R.string.click_pick)

    object LemonBefore: Abstract(R.string.click_lemon)

    object LemonAfter: Abstract(R.string.click_squeeze)

    object Juice: Abstract(R.string.click_drink)

    object Glass: Abstract(R.string.click_again)
}