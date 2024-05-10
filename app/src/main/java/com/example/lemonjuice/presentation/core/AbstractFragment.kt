package com.example.lemonjuice.presentation.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.lemonjuice.databinding.FragmentMainBinding

abstract class AbstractFragment(
    @DrawableRes private val imageResId: Int,
    @StringRes private val descResId: Int,
    @StringRes private val actionTextResId: Int,
    @StringRes private val hintResId: Int,
) : Fragment() {

    private var _binding: FragmentMainBinding? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        actionImageButton.setImageResource(imageResId)
        actionImageButton.contentDescription = getString(descResId)
        actionButton.setText(actionTextResId)
        hintTextView.setText(hintResId)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}