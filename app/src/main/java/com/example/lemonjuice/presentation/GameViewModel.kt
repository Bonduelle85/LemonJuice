package com.example.lemonjuice.presentation

import com.example.lemonjuice.data.Repository
import com.example.lemonjuice.presentation.lemon.LemonUiState
import com.example.lemonjuice.views.button.ActionButtonUiState
import com.example.lemonjuice.views.image.ActionImageButtonUiState
import com.example.lemonjuice.views.text.HintTextViewUiState

class GameViewModel(
    private val repository: Repository
) : Actions {

    fun init(): LemonUiState {
        return LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
    }

    fun handleImageButton(): LemonUiState {
        repository.increment()
        return if (repository.isLast()) {
            LemonUiState.LemonAfter(
                actionImageButtonUiState = ActionImageButtonUiState.LemonAfter,
                actionButtonUiState = ActionButtonUiState.LemonAfter,
                hintTextViewUiState = HintTextViewUiState.LemonAfter,
            )
        } else {
            LemonUiState.LemonBefore(
                actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
                actionButtonUiState = ActionButtonUiState.LemonBefore,
                hintTextViewUiState = HintTextViewUiState.LemonBefore,
            )
        }
    }

    override fun goLemonBefore(): LemonUiState {
        return LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
    }

    override fun goAgain() {
        repository.reset()
    }
}

interface Actions {
    fun goAgain()
    fun goLemonBefore(): LemonUiState
}