package com.example.lemonjuice.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lemonjuice.LemonJuiceApp
import com.example.lemonjuice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var uiState: UiState

        val viewModel = (application as LemonJuiceApp).viewModel

        binding.actionButton.setOnClickListener {
            uiState = binding.actionButton.handleAction(viewModel)
            uiState.update(binding.actionImageButton, binding.actionButton, binding.hintTextView)
        }

        binding.actionImageButton.setOnClickListener {
            uiState = viewModel.handleImageButton()
            uiState.update(binding.actionImageButton, binding.actionButton, binding.hintTextView)
        }

        uiState = viewModel.init(savedInstanceState == null)
        uiState.update(binding.actionImageButton, binding.actionButton, binding.hintTextView)
    }
}