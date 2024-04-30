package com.example.lemonjuice

import com.example.lemonjuice.databinding.ActivityMainBinding
import java.io.Serializable

interface UiState : Serializable {

    fun update(binding: ActivityMainBinding)
    fun handleAction(viewModel: Actions): UiState


    data class Tree(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            binding.actionImageButton.updateUiState(actionImageButtonUiState)
            binding.actionButton.updateUiState(actionButtonUiState)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goLemonBefore()
        }
    }

    data class LemonBefore(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            binding.actionImageButton.updateUiState(actionImageButtonUiState)
            binding.actionButton.updateUiState(actionButtonUiState)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions) = throw IllegalStateException("need to squeeze")
    }

    data class LemonAfter(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            binding.actionImageButton.updateUiState(actionImageButtonUiState)
            binding.actionButton.updateUiState(actionButtonUiState)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToJuice()
        }
    }

    data class Juice(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            binding.actionImageButton.updateUiState(actionImageButtonUiState)
            binding.actionButton.updateUiState(actionButtonUiState)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goToGlass()
        }
    }

    data class Glass(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(binding: ActivityMainBinding) {
            binding.actionImageButton.updateUiState(actionImageButtonUiState)
            binding.actionButton.updateUiState(actionButtonUiState)
            hintTextView.show(binding.hintTextView)
        }

        override fun handleAction(viewModel: Actions): UiState {
            return viewModel.goAgain()
        }
    }
}