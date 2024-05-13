package com.example.lemonjuice.data

import com.example.lemonjuice.presentation.lemon.LemonScreen

interface LemonRepository {

    fun increment()
    fun isLast(): Boolean
    fun reset()
    fun saveLastScreenIsLemon()

    class Base(
        private val lastScreen: StringCache,
        private var counter: IntCache,
    ) : LemonRepository {

        override fun increment() {
            val old = counter.read()
            val new = old + 1
            counter.save(new)
        }

        override fun isLast() = counter.read() == 5

        override fun reset() {
            counter.save(0)
        }

        override fun saveLastScreenIsLemon() {
            lastScreen.save(LemonScreen::class.java.canonicalName)
        }
    }
}