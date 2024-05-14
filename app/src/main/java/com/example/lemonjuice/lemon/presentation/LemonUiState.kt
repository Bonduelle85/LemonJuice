package com.example.lemonjuice.lemon.presentation

import com.example.lemonjuice.core.views.button.ActionButtonUiState
import com.example.lemonjuice.core.views.button.UpdateButton
import com.example.lemonjuice.core.views.image.ActionImageButtonUiState
import com.example.lemonjuice.core.views.image.UpdateImage
import com.example.lemonjuice.core.views.text.HintTextViewUiState
import com.example.lemonjuice.core.views.text.UpdateText


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