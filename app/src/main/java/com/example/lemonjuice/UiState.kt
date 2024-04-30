package com.example.lemonjuice

import com.example.lemonjuice.databinding.ActivityMainBinding
import java.io.Serializable

interface UiState : Serializable {

    fun update(binding: ActivityMainBinding)
    fun handleAction(viewModel: Actions): UiState


    data class Tree(
        private val imageButtonUiState: ImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            imageButtonUiState.show(binding.imageButton)
            actionButtonUiState.show(binding.actionButton)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goLemonBefore()
        }
    }

    data class LemonBefore(
        private val imageButtonUiState: ImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            imageButtonUiState.show(binding.imageButton)
            actionButtonUiState.show(binding.actionButton)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions) = throw IllegalStateException("need to squeeze")
    }

    data class LemonAfter(
        private val imageButtonUiState: ImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            imageButtonUiState.show(binding.imageButton)
            actionButtonUiState.show(binding.actionButton)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToJuice()
        }
    }

    data class Juice(
        private val imageButtonUiState: ImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            imageButtonUiState.show(binding.imageButton)
            actionButtonUiState.show(binding.actionButton)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToGlass()
        }
    }

    data class Glass(
        private val imageButtonUiState: ImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            imageButtonUiState.show(binding.imageButton)
            actionButtonUiState.show(binding.actionButton)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goAgain()
        }
    }
}