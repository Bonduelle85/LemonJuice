package com.example.lemonjuice.views.button

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.example.lemonjuice.presentation.Actions
import com.example.lemonjuice.presentation.UiState

class ActionButton : AppCompatButton, UpdateButton {

    private lateinit var uiState: ActionButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    fun handleAction(viewModel: Actions): UiState = uiState.handleAction(viewModel)

    override fun updateUiState(outer: ActionButtonUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ActionButtonSavedState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ActionButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}

interface UpdateButton{
    fun updateUiState(outer: ActionButtonUiState)
}