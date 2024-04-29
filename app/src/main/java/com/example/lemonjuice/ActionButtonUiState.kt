package com.example.lemonjuice

import androidx.appcompat.widget.AppCompatButton

interface ActionButtonUiState {

    fun show(actionButton: AppCompatButton)

    object Tree: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.pick)
            actionButton.isEnabled = true
        }
    }

    object LemonBefore: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.squeeze)
            actionButton.isEnabled = false
        }
    }

    object LemonAfter: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.squeeze)
            actionButton.isEnabled = true
        }
    }

    object Juice: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.drink)
            actionButton.isEnabled = true
        }
    }

    object Glass: ActionButtonUiState{
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.again)
            actionButton.isEnabled = true
        }
    }
}