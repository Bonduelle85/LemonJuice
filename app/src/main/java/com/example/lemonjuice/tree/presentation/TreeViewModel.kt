package com.example.lemonjuice.tree.presentation

import com.example.lemonjuice.tree.data.TreeRepository
import com.example.lemonjuice.main.presentation.MyViewModel

class TreeViewModel(
    private val glassRepository: TreeRepository
) : MyViewModel {

    fun init() {
        glassRepository.saveLastScreenIsTree()
    }
}