package com.example.lemonjuice.presentation

import com.example.lemonjuice.views.button.ActionButtonUiState
import com.example.lemonjuice.views.button.UpdateButton
import com.example.lemonjuice.views.image.ActionImageButtonUiState
import com.example.lemonjuice.views.image.UpdateImage
import com.example.lemonjuice.views.text.HintTextViewUiState
import com.example.lemonjuice.views.text.UpdateText


interface LemonUiState {

    fun update(
        actionImageButton: UpdateImage,
        actionButton: UpdateButton,
        hintTextView: UpdateText,
    )

    data class LemonBefore(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextViewUiState: HintTextViewUiState,
    ) : LemonUiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
            hintTextViewUiState.show(hintTextView)
        }
    }

    data class LemonAfter(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextViewUiState: HintTextViewUiState,
    ) : LemonUiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
            hintTextViewUiState.show(hintTextView)
        }
    }
}