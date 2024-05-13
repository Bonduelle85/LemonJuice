package com.example.lemonjuice

import android.app.Application
import android.content.Context
import com.example.lemonjuice.data.PermanentStorage
import com.example.lemonjuice.data.StringCache
import com.example.lemonjuice.presentation.core.ManageViewModels
import com.example.lemonjuice.presentation.core.ProvideViewModel
import com.example.lemonjuice.presentation.lemon.LemonViewModel
import com.example.lemonjuice.presentation.main.MyViewModel
import com.example.lemonjuice.presentation.tree.TreeScreen

class LemonJuiceApp : Application(), ManageViewModels {

    private lateinit var factory: ManageViewModels

    override fun onCreate() {
        super.onCreate()

        factory = ProvideViewModel.Factory(ProvideViewModel.Make(Core(this)))
    }

    override fun clear(clazz: Class<out MyViewModel>) {
        factory.clear(clazz)
    }

    override fun <T : MyViewModel> viewModel(clazz: Class<T>): T {
        return factory.viewModel(clazz)
    }
}

class Core(context: Context) {
    val name = context.getString(R.string.app_name)
    val permanentStorage = PermanentStorage.Base(context.getSharedPreferences(name, Context.MODE_PRIVATE))
    val lastScreen =
        StringCache.Base("lastScreen", permanentStorage, TreeScreen::class.java.canonicalName)
}


