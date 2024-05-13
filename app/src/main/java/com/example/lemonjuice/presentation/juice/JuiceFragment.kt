package com.example.lemonjuice.presentation.juice

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R
import com.example.lemonjuice.presentation.core.AbstractFragment
import com.example.lemonjuice.presentation.core.ManageViewModels
import com.example.lemonjuice.presentation.glass.GlassViewModel

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
        viewModel.init()

        binding.actionButton.setOnClickListener {
            (requireActivity() as JuiceNavigation).navigateToGlass()
        }
    }
}

interface JuiceNavigation{
    fun navigateToGlass()
}