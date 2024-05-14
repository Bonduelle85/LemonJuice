package com.example.lemonjuice.glass.presentation

import com.example.lemonjuice.glass.data.GlassRepository
import com.example.lemonjuice.main.presentation.MyViewModel

class GlassViewModel(
    private val glassRepository: GlassRepository
) : MyViewModel {

    fun init() {
        glassRepository.saveLastScreenIsGlass()
    }
}