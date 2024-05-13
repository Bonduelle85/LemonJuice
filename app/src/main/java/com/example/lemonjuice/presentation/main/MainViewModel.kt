package com.example.lemonjuice.presentation.main

import com.example.lemonjuice.data.MainRepository
import com.example.lemonjuice.presentation.core.Screen

class MainViewModel(
    private val mainRepository: MainRepository
) : MyViewModel {

    fun init(firstRun: Boolean): Screen {
        return if (firstRun)
            mainRepository.lastSavedScreen()
        else
            Screen.Empty
    }
}

interface MyViewModel