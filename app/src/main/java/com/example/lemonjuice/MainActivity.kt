package com.example.lemonjuice

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lemonjuice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var uiState: UiState
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = (application as LemonJuiceApp).viewModel

        binding.actionButton.setOnClickListener {
            uiState = uiState.handleAction(viewModel)
            uiState.update(binding)
        }

        binding.imageButton.setOnClickListener {
            uiState = viewModel.handleImageButton()
            uiState.update(binding)
        }

        uiState = if (savedInstanceState == null) {
            viewModel.init()
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
            } else {
                savedInstanceState.getSerializable(KEY) as UiState
            }
        }
        uiState.update(binding)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    companion object {
        private const val KEY = "uiStateKey"
    }
}