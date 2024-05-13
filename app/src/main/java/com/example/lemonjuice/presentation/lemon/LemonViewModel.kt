package com.example.lemonjuice.presentation.lemon

import com.example.lemonjuice.data.LemonRepository
import com.example.lemonjuice.presentation.main.MyViewModel
import com.example.lemonjuice.views.button.ActionButtonUiState
import com.example.lemonjuice.views.image.ActionImageButtonUiState
import com.example.lemonjuice.views.text.HintTextViewUiState

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
            lemonRepository.saveLastScreenIsLemon() // init()
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