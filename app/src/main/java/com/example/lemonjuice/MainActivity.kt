package com.example.lemonjuice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lemonjuice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState
        val viewModel = GameViewModel(Repository.Base())

        binding.actionButton.setOnClickListener {
            uiState = uiState.handleAction(viewModel)
            uiState.update(binding)
        }

        binding.imageButton.setOnClickListener {
            uiState = viewModel.clickImageButton()
            uiState.update(binding)
        }

        uiState = viewModel.init()
        uiState.update(binding)
    }
}