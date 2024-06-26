package com.example.lemonjuice.core.views.button

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

class ActionButton : AppCompatButton, UpdateButton {

    private lateinit var uiState: ActionButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

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

    override fun updateText(resId: Int) {
        this.setText(resId)
    }

    override fun updateEnabled(isEnabled: Boolean) {
        this.isEnabled = isEnabled
    }
}

interface UpdateButton{
    fun updateUiState(outer: ActionButtonUiState)

    fun updateText(resId: Int)
    fun updateEnabled(isEnabled: Boolean)
}