package com.example.lemonjuice

import android.app.Application

class LemonJuiceApp: Application() {

    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()

        viewModel = GameViewModel(Repository.Base())
    }
}