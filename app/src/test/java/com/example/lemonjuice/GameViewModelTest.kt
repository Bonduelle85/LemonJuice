package com.example.lemonjuice

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
            imageButtonUiState = ImageButtonUiState.Tree,
            actionButtonUiState = ActionButtonUiState.Tree,
            hintTextView = HintTextViewUiState.Tree,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goLemonBefore()
        expectedUiState = UiState.LemonBefore(
            imageButtonUiState = ImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextView = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)


        actualUiState = viewModel.handleImageButton() // 1 LemonBefore
        expectedUiState = UiState.LemonBefore(
            imageButtonUiState = ImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextView = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 2 LemonBefore
        expectedUiState = UiState.LemonBefore(
            imageButtonUiState = ImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextView = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 3 LemonBefore
        expectedUiState = UiState.LemonBefore(
            imageButtonUiState = ImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextView = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 4 LemonBefore
        expectedUiState = UiState.LemonBefore(
            imageButtonUiState = ImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextView = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.handleImageButton() // 5 LemonAfter
        expectedUiState = UiState.LemonAfter(
            imageButtonUiState = ImageButtonUiState.LemonAfter,
            actionButtonUiState = ActionButtonUiState.LemonAfter,
            hintTextView = HintTextViewUiState.LemonAfter,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goToJuice() // Juice
        expectedUiState = UiState.Juice(
            imageButtonUiState = ImageButtonUiState.Juice,
            actionButtonUiState = ActionButtonUiState.Juice,
            hintTextView = HintTextViewUiState.Juice,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goToGlass() // Glass
        expectedUiState = UiState.Glass(
            imageButtonUiState = ImageButtonUiState.Glass,
            actionButtonUiState = ActionButtonUiState.Glass,
            hintTextView = HintTextViewUiState.Glass,
        )
        assertEquals(expectedUiState, actualUiState)

        actualUiState = viewModel.goAgain() // Tree
        expectedUiState = UiState.Tree(
            imageButtonUiState = ImageButtonUiState.Tree,
            actionButtonUiState = ActionButtonUiState.Tree,
            hintTextView = HintTextViewUiState.Tree,
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
    override fun getCounter() = clickCounter
}