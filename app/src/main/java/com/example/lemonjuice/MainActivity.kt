package com.example.lemonjuice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lemonjuice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = GameViewModel()

        binding.actionButton.setOnClickListener {
            val uiState: UiState = viewModel.nextStep()
            uiState.update(binding)
        }

        binding.actionImageButton.setOnClickListener {
            val uiState: UiState = viewModel.squeeze()
            uiState.update(binding)
        }

        val uiState: UiState = viewModel.init()
        uiState.update(binding)
    }
}