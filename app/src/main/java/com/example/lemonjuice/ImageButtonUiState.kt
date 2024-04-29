package com.example.lemonjuice

import android.widget.ImageButton

interface ImageButtonUiState {

    fun show(imageButton: ImageButton)

    object Tree: ImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.tree)
            imageButton.isClickable = false
        }
    }

    object LemonBefore: ImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_lemon)
            imageButton.isClickable = true
        }
    }

    object LemonAfter: ImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_lemon)
            imageButton.isClickable = false
        }
    }

    object Juice: ImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_juice)
            imageButton.isClickable = false
        }
    }

    object Glass: ImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_empty_glass)
            imageButton.isClickable = false
        }
    }
}