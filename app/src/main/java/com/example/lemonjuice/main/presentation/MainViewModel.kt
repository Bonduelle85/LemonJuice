package com.example.lemonjuice.main.presentation

import com.example.lemonjuice.main.data.MainRepository
import com.example.lemonjuice.core.presentation.Screen

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