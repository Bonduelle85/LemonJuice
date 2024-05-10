package com.example.lemonjuice.presentation.lemon

import androidx.fragment.app.Fragment
import com.example.lemonjuice.presentation.core.Screen

object LemonScreen : Screen.Replace() {

    override fun fragment(): Fragment {
        return LemonFragment()
    }
}