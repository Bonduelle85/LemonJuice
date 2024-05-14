package com.example.lemonjuice.glass.data

import com.example.lemonjuice.core.data.StringCache
import com.example.lemonjuice.glass.presentation.GlassScreen

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