package com.example.lemonjuice.views.image

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageButton

class ActionImageButton : AppCompatImageButton, UpdateImage {

    private lateinit var uiState: ActionImageButtonUiState

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateUiState(outer: ActionImageButtonUiState) {
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

    override fun updateImage(resId: Int) {
        this.setImageResource(resId)
    }

    override fun updateClickable(isClickable: Boolean) {
        this.isClickable = isClickable
    }

    override fun updateContentDescription(resId: Int) {
        this.contentDescription = this.context.getString(resId)
    }
}

interface UpdateImage{
    fun updateUiState(outer: ActionImageButtonUiState)

    fun updateImage(resId: Int)
    fun updateClickable(isClickable: Boolean)
    fun updateContentDescription(resId: Int)
}