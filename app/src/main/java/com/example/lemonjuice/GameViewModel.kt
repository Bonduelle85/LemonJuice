package com.example.lemonjuice

class GameViewModel(
    private val repository: Repository
): Actions {

    fun init(): UiState {
        return UiState.Tree(
            actionImageButtonUiState = ActionImageButtonUiState.Tree,
            actionButtonUiState = ActionButtonUiState.Tree,
            hintTextView = HintTextViewUiState.Tree,
        )
    }
    
    fun handleImageButton(): UiState {
        repository.increment()
        return if (repository.isLast()) {
            UiState.LemonAfter(
                actionImageButtonUiState = ActionImageButtonUiState.LemonAfter,
                actionButtonUiState = ActionButtonUiState.LemonAfter,
                hintTextView = HintTextViewUiState.LemonAfter,
            )
        } else {
            UiState.LemonBefore(
                actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
                actionButtonUiState = ActionButtonUiState.LemonBefore,
                hintTextView = HintTextViewUiState.LemonBefore,
            )
        }
    }

    override fun goLemonBefore(): UiState {
        return UiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextView = HintTextViewUiState.LemonBefore,
        )
    }

    override fun goToJuice(): UiState {
        return UiState.Juice(
            actionImageButtonUiState = ActionImageButtonUiState.Juice,
            actionButtonUiState = ActionButtonUiState.Juice,
            hintTextView = HintTextViewUiState.Juice,
        )
    }

    override fun goToGlass(): UiState {
        return UiState.Glass(
            actionImageButtonUiState = ActionImageButtonUiState.Glass,
            actionButtonUiState = ActionButtonUiState.Glass,
            hintTextView = HintTextViewUiState.Glass,
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