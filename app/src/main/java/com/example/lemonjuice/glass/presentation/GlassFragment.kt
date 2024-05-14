package com.example.lemonjuice.glass.presentation

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R
import com.example.lemonjuice.core.presentation.AbstractFragment
import com.example.lemonjuice.core.di.ManageViewModels

class GlassFragment : AbstractFragment(
    imageResId = R.drawable.ic_empty_glass,
    descResId = R.string.glass,
    actionTextResId = R.string.again,
    hintResId = R.string.click_again,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(GlassViewModel::class.java)

        if (savedInstanceState == null) viewModel.init()

        binding.actionButton.setOnClickListener {
            manageViewModels.clear(GlassViewModel::class.java)
            (requireActivity() as GlassNavigation).navigateToTree()
        }
    }
}

interface GlassNavigation{
    fun navigateToTree()
}