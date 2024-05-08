package com.example.lemonjuice.presentation

import com.example.lemonjuice.views.button.ActionButtonUiState
import com.example.lemonjuice.views.button.UpdateButton
import com.example.lemonjuice.views.image.ActionImageButtonUiState
import com.example.lemonjuice.views.image.UpdateImage
import com.example.lemonjuice.views.text.HintTextViewUiState
import com.example.lemonjuice.views.text.UpdateText


interface UiState {

    fun update(
        actionImageButton: UpdateImage,
        actionButton: UpdateButton,
        hintTextView: UpdateText,
    )

    object Empty : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText
        ) = Unit
    }

    data class Tree(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextViewUiState: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
//            hintTextView.updateText(R.string.click_pick)
            hintTextViewUiState.show(hintTextView)
        }
    }

    data class LemonBefore(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextViewUiState: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
//            hintTextView.updateText(R.string.click_lemon)
            hintTextViewUiState.show(hintTextView)
        }
    }

    data class LemonAfter(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextViewUiState: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
//            hintTextView.updateText(R.string.click_squeeze)
            hintTextViewUiState.show(hintTextView)
        }
    }

    data class Juice(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextViewUiState: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
//            hintTextView.updateText(R.string.click_drink)
            hintTextViewUiState.show(hintTextView)
        }

    }

    data class Glass(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextViewUiState: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
//            hintTextView.updateText(R.string.click_again)
            hintTextViewUiState.show(hintTextView)
        }
    }
}