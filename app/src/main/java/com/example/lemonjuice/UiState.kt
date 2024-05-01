package com.example.lemonjuice


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
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
            hintTextView.updateText(R.string.click_pick)
        }
    }

    data class LemonBefore(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
            hintTextView.updateText(R.string.click_lemon)
        }
    }

    data class LemonAfter(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
            hintTextView.updateText(R.string.click_squeeze)
        }
    }

    data class Juice(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
            hintTextView.updateText(R.string.click_drink)
        }

    }

    data class Glass(
        private val actionImageButtonUiState: ActionImageButtonUiState,
        private val actionButtonUiState: ActionButtonUiState,
        private val hintTextView: HintTextViewUiState,
    ) : UiState {
        override fun update(
            actionImageButton: UpdateImage,
            actionButton: UpdateButton,
            hintTextView: UpdateText,
        ) {
            actionImageButton.updateUiState(actionImageButtonUiState)
            actionButton.updateUiState(actionButtonUiState)
            hintTextView.updateText(R.string.click_again)
        }
    }
}