package com.example.lemonjuice.presentation.tree

import com.example.lemonjuice.data.TreeRepository
import com.example.lemonjuice.presentation.main.MyViewModel

class TreeViewModel(
    private val glassRepository: TreeRepository
) : MyViewModel {

    fun init() {
        glassRepository.saveLastScreenIsTree()
    }
}