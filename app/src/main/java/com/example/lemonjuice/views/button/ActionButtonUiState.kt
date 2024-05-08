package com.example.lemonjuice.views.button

import com.example.lemonjuice.R
import com.example.lemonjuice.presentation.Actions
import com.example.lemonjuice.presentation.UiState
import java.io.Serializable

interface ActionButtonUiState : Serializable {

    fun show(updateButton: UpdateButton)
    fun handleAction(viewModel: Actions): UiState

    object Tree: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.pick)
            updateButton.updateEnabled(true)
        }
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goLemonBefore()
        }
    }

    object LemonBefore: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.squeeze)
            updateButton.updateEnabled(false)
        }
        override fun handleAction(viewModel: Actions): UiState {
            throw IllegalStateException("cant click action button")
        }
    }

    object LemonAfter: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.squeeze)
            updateButton.updateEnabled(true)
        }
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToJuice()
        }
    }

    object Juice: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.drink)
            updateButton.updateEnabled(true)
        }
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToGlass()
        }
    }

    object Glass: ActionButtonUiState {
        override fun show(updateButton: UpdateButton) {
            updateButton.updateText(R.string.again)
            updateButton.updateEnabled(true)
        }
        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goAgain()
        }
    }
}