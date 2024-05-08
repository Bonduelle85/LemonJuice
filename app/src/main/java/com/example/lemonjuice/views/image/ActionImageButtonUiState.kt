package com.example.lemonjuice.views.image

import android.widget.ImageButton
import com.example.lemonjuice.R
import java.io.Serializable

interface ActionImageButtonUiState : Serializable {

    fun show(imageButton: ImageButton)

    object Tree: ActionImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.tree)
            imageButton.isClickable = false
        }
    }

    object LemonBefore: ActionImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_lemon)
            imageButton.isClickable = true
        }
    }

    object LemonAfter: ActionImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_lemon)
            imageButton.isClickable = false
        }
    }

    object Juice: ActionImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_juice)
            imageButton.isClickable = false
        }
    }

    object Glass: ActionImageButtonUiState {
        override fun show(imageButton: ImageButton) {
            imageButton.setImageResource(R.drawable.ic_empty_glass)
            imageButton.isClickable = false
        }
    }
}