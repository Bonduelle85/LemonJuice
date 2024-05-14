package com.example.lemonjuice.lemon.presentation

import androidx.fragment.app.Fragment
import com.example.lemonjuice.core.presentation.Screen

object LemonScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return LemonFragment()
    }
}