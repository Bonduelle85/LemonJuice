package com.example.lemonjuice.presentation.juice

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.core.Screen

object JuiceScreen : Screen.Replace() {
    override fun fragment(): Fragment {
        return JuiceFragment()
    }
}