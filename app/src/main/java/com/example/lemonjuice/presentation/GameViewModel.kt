package com.example.lemonjuice.presentation

import com.example.lemonjuice.data.Repository
import com.example.lemonjuice.views.button.ActionButtonUiState
import com.example.lemonjuice.views.image.ActionImageButtonUiState
import com.example.lemonjuice.views.text.HintTextViewUiState

class GameViewModel(
    private val repository: Repository
): Actions {

    fun init(isFirstTime: Boolean = true): UiState {
        return if (isFirstTime) {
            UiState.Tree(
                actionImageButtonUiState = ActionImageButtonUiState.Tree,
                actionButtonUiState = ActionButtonUiState.Tree,
                hintTextViewUiState = HintTextViewUiState.Tree,
            )
        } else {
            UiState.Empty
        }
    }
    
    fun handleImageButton(): UiState {
        repository.increment()
        return if (repository.isLast()) {
            UiState.LemonAfter(
                actionImageButtonUiState = ActionImageButtonUiState.LemonAfter,
                actionButtonUiState = ActionButtonUiState.LemonAfter,
                hintTextViewUiState = HintTextViewUiState.LemonAfter,
            )
        } else {
            UiState.LemonBefore(
                actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
                actionButtonUiState = ActionButtonUiState.LemonBefore,
                hintTextViewUiState = HintTextViewUiState.LemonBefore,
            )
        }
    }

    override fun goLemonBefore(): UiState {
        return UiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
    }

    override fun goToJuice(): UiState {
        return UiState.Juice(
            actionImageButtonUiState = ActionImageButtonUiState.Juice,
            actionButtonUiState = ActionButtonUiState.Juice,
            hintTextViewUiState = HintTextViewUiState.Juice,
        )
    }

    override fun goToGlass(): UiState {
        return UiState.Glass(
            actionImageButtonUiState = ActionImageButtonUiState.Glass,
            actionButtonUiState = ActionButtonUiState.Glass,
            hintTextViewUiState = HintTextViewUiState.Glass,
        )
    }

    override fun goAgain(): UiState {
        repository.reset()
        return init()
    }
}

interface Actions{
    fun goToGlass(): UiState
    fun goToJuice(): UiState
    fun goAgain(): UiState
    fun goLemonBefore(): UiState
}