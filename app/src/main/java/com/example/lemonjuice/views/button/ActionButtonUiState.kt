package com.example.lemonjuice.views.button

import com.example.lemonjuice.R
import java.io.Serializable

interface ActionButtonUiState : Serializable {

    fun show(updateButton: UpdateButton)

    object Tree: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.pick)
            updateButton.updateEnabled(true)
        }
    }

    object LemonBefore: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.squeeze)
            updateButton.updateEnabled(false)
        }
    }

    object LemonAfter: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.squeeze)
            updateButton.updateEnabled(true)
        }
    }

    object Juice: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.drink)
            updateButton.updateEnabled(true)
        }
    }

    object Glass: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.again)
            updateButton.updateEnabled(true)
        }
    }
}