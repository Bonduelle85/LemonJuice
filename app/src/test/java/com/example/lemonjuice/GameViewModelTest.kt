package com.example.lemonjuice

import com.example.lemonjuice.data.Repository
import com.example.lemonjuice.presentation.GameViewModel
import com.example.lemonjuice.presentation.UiState
import com.example.lemonjuice.views.button.ActionButtonUiState
import com.example.lemonjuice.views.image.ActionImageButtonUiState
import com.example.lemonjuice.views.text.HintTextViewUiState
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class GameViewModelTest {

    private lateinit var viewModel: GameViewModel
    private lateinit var repository: FakeRepository

    @Before
    fun setup() {
        repository = FakeRepository()
        viewModel = GameViewModel(
            repository = repository
        )
    }

    @Test
    fun case() {
        var actualUiState: UiState = viewModel.init() // Tree
        var expectedUiState: UiState = UiState.Tree(
            actionImageButtonUiState = ActionImageButtonUiState.Tree,
            actionButtonUiState = ActionButtonUiState.Tree,
            hintTextViewUiState = HintTextViewUiState.Tree,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goLemonBefore()
        expectedUiState = UiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)


        actualUiState = viewModel.handleImageButton() // 1 LemonBefore
        expectedUiState = UiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 2 LemonBefore
        expectedUiState = UiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 3 LemonBefore
        expectedUiState = UiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 4 LemonBefore
        expectedUiState = UiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 5 LemonAfter
        expectedUiState = UiState.LemonAfter(
            actionImageButtonUiState = ActionImageButtonUiState.LemonAfter,
            actionButtonUiState = ActionButtonUiState.LemonAfter,
            hintTextViewUiState = HintTextViewUiState.LemonAfter,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goToJuice() // Juice
        expectedUiState = UiState.Juice(
            actionImageButtonUiState = ActionImageButtonUiState.Juice,
            actionButtonUiState = ActionButtonUiState.Juice,
            hintTextViewUiState = HintTextViewUiState.Juice,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goToGlass() // Glass
        expectedUiState = UiState.Glass(
            actionImageButtonUiState = ActionImageButtonUiState.Glass,
            actionButtonUiState = ActionButtonUiState.Glass,
            hintTextViewUiState = HintTextViewUiState.Glass,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goAgain() // Tree
        expectedUiState = UiState.Tree(
            actionImageButtonUiState = ActionImageButtonUiState.Tree,
            actionButtonUiState = ActionButtonUiState.Tree,
            hintTextViewUiState = HintTextViewUiState.Tree,
        )
        assertEquals(expectedUiState, actualUiState)
    }
}

private class FakeRepository : Repository {

    private var clickCounter = 0

    override fun increment() {
        clickCounter++
    }
    override fun isLast() = clickCounter == 5
    override fun reset() {
        clickCounter = 0
    }
}