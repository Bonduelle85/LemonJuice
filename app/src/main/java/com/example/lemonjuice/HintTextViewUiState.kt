package com.example.lemonjuice

import androidx.annotation.StringRes

interface HintTextViewUiState {

    fun show(textView: UpdateText)

    abstract class Abstract(
        @StringRes private val resId: Int
    ) : HintTextViewUiState {
        override fun show(textView: UpdateText) {
            textView.updateText(resId)
        }
    }

    object Tree: Abstract(R.string.click_pick)

    object LemonBefore: Abstract(R.string.click_lemon)

    object LemonAfter: Abstract(R.string.click_squeeze)

    object Juice: Abstract(R.string.click_drink)

    object Glass: Abstract(R.string.click_again)
}