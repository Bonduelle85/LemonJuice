package com.example.lemonjuice.data

import com.example.lemonjuice.presentation.tree.TreeScreen

interface TreeRepository {

    fun saveLastScreenIsTree()

    class Base(
        private val lastScreen: StringCache,
    ) : TreeRepository {

        override fun saveLastScreenIsTree() {
            lastScreen.save(TreeScreen::class.java.canonicalName)
        }
    }
}