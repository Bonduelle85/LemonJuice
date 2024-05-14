package com.example.lemonjuice.juice.data

import com.example.lemonjuice.core.data.StringCache
import com.example.lemonjuice.juice.presentation.JuiceScreen

interface JuiceRepository {

    fun saveLastScreenIsJuice()

    class Base(
        private val lastScreen: StringCache,
    ) : JuiceRepository {

        override fun saveLastScreenIsJuice() {
            lastScreen.save(JuiceScreen::class.java.canonicalName)
        }
    }
}