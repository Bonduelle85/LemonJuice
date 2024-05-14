package com.example.lemonjuice.tree.presentation

import androidx.fragment.app.Fragment
import com.example.lemonjuice.core.presentation.Screen

object TreeScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return TreeFragment()
    }
}