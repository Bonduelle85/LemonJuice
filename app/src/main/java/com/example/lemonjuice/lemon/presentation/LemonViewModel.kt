package com.example.lemonjuice.lemon.presentation

import com.example.lemonjuice.lemon.data.LemonRepository
import com.example.lemonjuice.main.presentation.MyViewModel
import com.example.lemonjuice.core.views.button.ActionButtonUiState
import com.example.lemonjuice.core.views.image.ActionImageButtonUiState
import com.example.lemonjuice.core.views.text.HintTextViewUiState

class LemonViewModel(
    private val lemonRepository: LemonRepository
) : MyViewModel, Actions {

    fun init(): LemonUiState {
        lemonRepository.saveLastScreenIsLemon()
        return LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
    }

    fun handleImageButton(): LemonUiState {
        lemonRepository.increment()
        return if (lemonRepository.isLast()) {
            lemonRepository.saveLastScreenIsLemon()
            LemonUiState.LemonAfter(
                actionImageButtonUiState = ActionImageButtonUiState.LemonAfter,
                actionButtonUiState = ActionButtonUiState.LemonAfter,
                hintTextViewUiState = HintTextViewUiState.LemonAfter,
            )
        } else {
            lemonRepository.saveLastScreenIsLemon() // replace - init()
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

    override fun resetCounter() {
        lemonRepository.reset()
    }
}

interface Actions {
    fun resetCounter()
    fun goLemonBefore(): LemonUiState
}