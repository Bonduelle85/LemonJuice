package com.example.lemonjuice.data

import com.example.lemonjuice.presentation.glass.GlassScreen

interface GlassRepository {

    fun saveLastScreenIsGlass()

    class Base(
        private val lastScreen: StringCache,
    ) : GlassRepository {

        override fun saveLastScreenIsGlass() {
            lastScreen.save(GlassScreen::class.java.canonicalName)
        }
    }
}