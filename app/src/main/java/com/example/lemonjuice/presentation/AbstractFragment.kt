package com.example.lemonjuice.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.example.lemonjuice.databinding.FragmentMainBinding

abstract class AbstractFragment(
    @DrawableRes private val actionImageButtonImageResId: Int,
    @StringRes private val actionImageButtonDescResId: Int,
    @StringRes private val actionButtonTextResId: Int,
    @StringRes private val hintTextViewTextResId: Int,
) : Fragment() {

    protected var _binding: FragmentMainBinding? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        with(binding) {
            actionImageButton.setImageResource(actionImageButtonImageResId)
            actionImageButton.contentDescription = requireContext().getString(actionImageButtonDescResId)
            actionButton.text = requireContext().getString(actionButtonTextResId)
            hintTextView.text = requireContext().getString(hintTextViewTextResId)
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}