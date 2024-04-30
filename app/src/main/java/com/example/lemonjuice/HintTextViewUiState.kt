package com.example.lemonjuice

import android.widget.TextView

interface HintTextViewUiState {

    fun show(textView: TextView)

    object Tree: HintTextViewUiState {
        override fun show(textView: TextView) {
            textView.setText(R.string.click_pick)
        }
    }

    object LemonBefore: HintTextViewUiState {
        override fun show(textView: TextView) {
            textView.setText(R.string.click_lemon)
        }
    }

    object LemonAfter: HintTextViewUiState {
        override fun show(textView: TextView) {
            textView.setText(R.string.click_squeeze)
        }
    }

    object Juice: HintTextViewUiState {
        override fun show(textView: TextView) {
            textView.setText(R.string.click_drink)
        }
    }

    object Glass: HintTextViewUiState{
        override fun show(textView: TextView) {
            textView.setText(R.string.click_again)
        }
    }
}