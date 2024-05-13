package com.example.lemonjuice.presentation.lemon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonjuice.LemonJuiceApp
import com.example.lemonjuice.databinding.FragmentLemonBinding
import com.example.lemonjuice.presentation.core.ManageViewModels

class LemonFragment : Fragment() {

    private var _binding: FragmentLemonBinding? = null
    private val binding get() = _binding!!

    private lateinit var lemonUiState: LemonUiState

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(LemonViewModel::class.java)

        binding.actionButton.setOnClickListener {
            viewModel.resetCounter()
            (requireActivity() as LemonNavigation).navigateToJuice()
        }

        binding.actionImageButton.setOnClickListener {
            lemonUiState = viewModel.handleImageButton()
            lemonUiState.update(binding.actionImageButton, binding.actionButton, binding.hintTextView)
        }

        lemonUiState = viewModel.init()
        lemonUiState.update(binding.actionImageButton, binding.actionButton, binding.hintTextView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

interface LemonNavigation{
    fun navigateToJuice()
}
