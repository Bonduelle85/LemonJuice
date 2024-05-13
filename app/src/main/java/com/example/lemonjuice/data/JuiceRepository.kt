package com.example.lemonjuice.data

import com.example.lemonjuice.presentation.juice.JuiceScreen

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