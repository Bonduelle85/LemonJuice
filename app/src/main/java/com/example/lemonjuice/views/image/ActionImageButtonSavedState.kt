package com.example.lemonjuice.views.image

import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View

class ActionImageButtonSavedState : View.BaseSavedState {

    private lateinit var state: ActionImageButtonUiState

    constructor(superState: Parcelable) : super(superState)

    private constructor(parcelIn: Parcel) : super(parcelIn) {
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            parcelIn.readSerializable(
                ActionImageButtonUiState::class.java.classLoader,
                ActionImageButtonUiState::class.java
            ) as ActionImageButtonUiState
        } else {
            parcelIn.readSerializable() as ActionImageButtonUiState
        }
    }

    override fun writeToParcel(out: Parcel, flags: Int) {
        super.writeToParcel(out, flags)
        out.writeSerializable(state)
    }

    fun restore(): ActionImageButtonUiState = state

    fun save(uiState: ActionImageButtonUiState) {
        state = uiState
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<ActionImageButtonSavedState> {
        override fun createFromParcel(parcel: Parcel): ActionImageButtonSavedState =
            ActionImageButtonSavedState(parcel)

        override fun newArray(size: Int): Array<ActionImageButtonSavedState?> =
            arrayOfNulls(size)
    }
}