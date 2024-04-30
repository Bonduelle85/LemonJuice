package com.example.lemonjuice

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet

class ActionImageButton : androidx.appcompat.widget.AppCompatImageButton {

    private lateinit var uiState: ActionImageButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    fun updateUiState(outer: ActionImageButtonUiState) {
        uiState = outer
        uiState.show(this)
    }

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val state = ActionImageButtonSavedState(it)
            state.save(uiState)
            return state
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as ActionImageButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        updateUiState(restoredState.restore())
    }
}