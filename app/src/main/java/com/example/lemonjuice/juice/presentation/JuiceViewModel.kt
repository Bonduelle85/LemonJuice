package com.example.lemonjuice.juice.presentation

import com.example.lemonjuice.juice.data.JuiceRepository
import com.example.lemonjuice.main.presentation.MyViewModel

class JuiceViewModel (
    private val glassRepository: JuiceRepository
) : MyViewModel {

    fun init() {
        glassRepository.saveLastScreenIsJuice()
    }
}