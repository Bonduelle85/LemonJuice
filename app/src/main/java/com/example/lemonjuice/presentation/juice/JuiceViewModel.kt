package com.example.lemonjuice.presentation.juice

import com.example.lemonjuice.data.JuiceRepository
import com.example.lemonjuice.presentation.main.MyViewModel

class JuiceViewModel (
    private val glassRepository: JuiceRepository
) : MyViewModel {

    fun init() {
        glassRepository.saveLastScreenIsJuice()
    }
}