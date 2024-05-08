package com.example.lemonjuice.views.button

import androidx.appcompat.widget.AppCompatButton
import com.example.lemonjuice.presentation.Actions
import com.example.lemonjuice.R
import com.example.lemonjuice.presentation.UiState
import java.io.Serializable

interface ActionButtonUiState : Serializable {

    fun show(actionButton: AppCompatButton)
    fun handleAction(viewModel: Actions): UiState

    object Tree: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.pick)
            actionButton.isEnabled = true
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goLemonBefore()
        }
    }

    object LemonBefore: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.squeeze)
            actionButton.isEnabled = false
        }

        override fun handleAction(viewModel: Actions): UiState {
            throw IllegalStateException("cant click action button")
        }
    }

    object LemonAfter: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.squeeze)
            actionButton.isEnabled = true
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToJuice()
        }
    }

    object Juice: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.drink)
            actionButton.isEnabled = true
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToGlass()
        }
    }

    object Glass: ActionButtonUiState {
        override fun show(actionButton: AppCompatButton) {
            actionButton.setText(R.string.again)
            actionButton.isEnabled = true
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goAgain()
        }
    }
}