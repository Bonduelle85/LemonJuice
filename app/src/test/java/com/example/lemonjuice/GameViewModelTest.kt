package com.example.lemonjuice

import com.example.lemonjuice.data.Repository
import com.example.lemonjuice.presentation.GameViewModel
import com.example.lemonjuice.presentation.LemonUiState
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
        var actualLemonUiState: LemonUiState = viewModel.init() // Tree
        var expectedLemonUiState: LemonUiState = LemonUiState.Tree(
            actionImageButtonUiState = ActionImageButtonUiState.Tree,
            actionButtonUiState = ActionButtonUiState.Tree,
            hintTextViewUiState = HintTextViewUiState.Tree,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.goLemonBefore()
        expectedLemonUiState = LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)


        actualLemonUiState = viewModel.handleImageButton() // 1 LemonBefore
        expectedLemonUiState = LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.handleImageButton() // 2 LemonBefore
        expectedLemonUiState = LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.handleImageButton() // 3 LemonBefore
        expectedLemonUiState = LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.handleImageButton() // 4 LemonBefore
        expectedLemonUiState = LemonUiState.LemonBefore(
            actionImageButtonUiState = ActionImageButtonUiState.LemonBefore,
            actionButtonUiState = ActionButtonUiState.LemonBefore,
            hintTextViewUiState = HintTextViewUiState.LemonBefore,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.handleImageButton() // 5 LemonAfter
        expectedLemonUiState = LemonUiState.LemonAfter(
            actionImageButtonUiState = ActionImageButtonUiState.LemonAfter,
            actionButtonUiState = ActionButtonUiState.LemonAfter,
            hintTextViewUiState = HintTextViewUiState.LemonAfter,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.goToJuice() // Juice
        expectedLemonUiState = LemonUiState.Juice(
            actionImageButtonUiState = ActionImageButtonUiState.Juice,
            actionButtonUiState = ActionButtonUiState.Juice,
            hintTextViewUiState = HintTextViewUiState.Juice,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.goToGlass() // Glass
        expectedLemonUiState = LemonUiState.Glass(
            actionImageButtonUiState = ActionImageButtonUiState.Glass,
            actionButtonUiState = ActionButtonUiState.Glass,
            hintTextViewUiState = HintTextViewUiState.Glass,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)

        actualLemonUiState = viewModel.goAgain() // Tree
        expectedLemonUiState = LemonUiState.Tree(
            actionImageButtonUiState = ActionImageButtonUiState.Tree,
            actionButtonUiState = ActionButtonUiState.Tree,
            hintTextViewUiState = HintTextViewUiState.Tree,
        )
        assertEquals(expectedLemonUiState, actualLemonUiState)
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