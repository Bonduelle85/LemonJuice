package com.example.lemonjuice.core.views.image

import com.example.lemonjuice.R
import java.io.Serializable

interface ActionImageButtonUiState : Serializable {

    fun show(updateImage: UpdateImage)

    object Tree : ActionImageButtonUiState {
        override fun show(updateImage: UpdateImage) {
            updateImage.updateImage(R.drawable.ic_tree)
            updateImage.updateClickable(false)
            updateImage.updateContentDescription(R.string.tree)
        }
    }

    object LemonBefore : ActionImageButtonUiState {
        override fun show(updateImage: UpdateImage) {
            updateImage.updateImage(R.drawable.ic_lemon)
            updateImage.updateClickable(true)
            updateImage.updateContentDescription(R.string.lemon)
        }
    }

    object LemonAfter : ActionImageButtonUiState {
        override fun show(updateImage: UpdateImage) {
            updateImage.updateImage(R.drawable.ic_lemon)
            updateImage.updateClickable(false)
            updateImage.updateContentDescription(R.string.lemon)
        }
    }

    object Juice : ActionImageButtonUiState {
        override fun show(updateImage: UpdateImage) {
            updateImage.updateImage(R.drawable.ic_juice)
            updateImage.updateClickable(false)
            updateImage.updateContentDescription(R.string.juice)
        }
    }

    object Glass : ActionImageButtonUiState {
        override fun show(updateImage: UpdateImage) {
            updateImage.updateImage(R.drawable.ic_empty_glass)
            updateImage.updateClickable(false)
            updateImage.updateContentDescription(R.string.glass)
        }
    }
}