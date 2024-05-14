package com.example.lemonjuice.core.views.text

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.StringRes
import com.google.android.material.textview.MaterialTextView


class HintTextView : MaterialTextView, UpdateText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttrs: Int) : super(
        context,
        attributeSet,
        defStyleAttrs
    )

    override fun updateText(resId: Int) {
        setText(resId)
    }
}

interface UpdateText {
    fun updateText(@StringRes resId: Int)
}