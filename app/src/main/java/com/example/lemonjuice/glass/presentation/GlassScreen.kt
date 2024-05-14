package com.example.lemonjuice.glass.presentation

import androidx.fragment.app.Fragment
import com.example.lemonjuice.core.presentation.Screen

object GlassScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return  GlassFragment()
    }
}