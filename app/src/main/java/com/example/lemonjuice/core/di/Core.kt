package com.example.lemonjuice.core.di

import android.content.Context
import com.example.lemonjuice.R
import com.example.lemonjuice.core.data.PermanentStorage
import com.example.lemonjuice.core.data.StringCache
import com.example.lemonjuice.tree.presentation.TreeScreen

class Core(context: Context) {
    val name = context.getString(R.string.app_name)
    val permanentStorage =
        PermanentStorage.Base(context.getSharedPreferences(name, Context.MODE_PRIVATE))
    val lastScreen =
        StringCache.Base("lastScreen", permanentStorage, TreeScreen::class.java.canonicalName)
}