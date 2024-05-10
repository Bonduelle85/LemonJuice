package com.example.lemonjuice.presentation.tree

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.core.Screen

object TreeScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return TreeFragment()
    }
}