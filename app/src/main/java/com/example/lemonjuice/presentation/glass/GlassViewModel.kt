package com.example.lemonjuice.presentation.glass

import com.example.lemonjuice.data.GlassRepository
import com.example.lemonjuice.presentation.core.Screen
import com.example.lemonjuice.presentation.lemon.LemonUiState
import com.example.lemonjuice.presentation.main.MyViewModel

class GlassViewModel(
    private val glassRepository: GlassRepository
) : MyViewModel {

    fun init() {
        glassRepository.saveLastScreenIsGlass()
    }
}