package com.example.lemonjuice.tree.data

import com.example.lemonjuice.core.data.StringCache
import com.example.lemonjuice.tree.presentation.TreeScreen

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