package com.example.lemonjuice

import android.app.Application
import android.content.Context

class LemonJuiceApp : Application() {

    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()

        val permanentStorage = PermanentStorage.Base(
            getSharedPreferences(
                getString(R.string.app_name), Context.MODE_PRIVATE
            )
        )

        viewModel = GameViewModel(Repository.Base(
            IntCache.Base("counter", permanentStorage, 0)
        ))
    }
}