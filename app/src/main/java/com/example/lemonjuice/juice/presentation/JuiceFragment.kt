package com.example.lemonjuice.juice.presentation

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R
import com.example.lemonjuice.core.presentation.AbstractFragment
import com.example.lemonjuice.core.di.ManageViewModels

class JuiceFragment : AbstractFragment(
    imageResId = R.drawable.ic_juice,
    descResId = R.string.juice,
    actionTextResId = R.string.drink,
    hintResId = R.string.click_drink,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(JuiceViewModel::class.java)

        if (savedInstanceState == null) viewModel.init()

        binding.actionButton.setOnClickListener {
            manageViewModels.clear(JuiceViewModel::class.java)
            (requireActivity() as JuiceNavigation).navigateToGlass()
        }
    }
}

interface JuiceNavigation {
    fun navigateToGlass()
}