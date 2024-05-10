package com.example.lemonjuice.presentation.glass

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.core.Screen

object GlassScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return  GlassFragment()
    }
}