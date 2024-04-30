package com.example.lemonjuice

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            uiState.update(binding)
        }

        binding.actionImageButton.setOnClickListener {
            uiState = viewModel.handleImageButton()
            uiState.update(binding)
        }

        if (savedInstanceState == null) {
            uiState = viewModel.init().also {
                it.update(binding)
            }
        }
    }
}