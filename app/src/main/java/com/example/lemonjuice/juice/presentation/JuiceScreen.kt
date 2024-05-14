package com.example.lemonjuice.juice.presentation

import androidx.fragment.app.Fragment
import com.example.lemonjuice.core.presentation.Screen

object JuiceScreen : Screen.Replace() {
    override fun fragment(): Fragment {
        return JuiceFragment()
    }
}