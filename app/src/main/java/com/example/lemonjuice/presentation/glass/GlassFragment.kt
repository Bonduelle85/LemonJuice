package com.example.lemonjuice.presentation.glass

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.LemonJuiceApp
import com.example.lemonjuice.R
import com.example.lemonjuice.presentation.core.AbstractFragment

class GlassFragment : AbstractFragment(
    imageResId = R.drawable.ic_empty_glass,
    descResId = R.string.glass,
    actionTextResId = R.string.again,
    hintResId = R.string.click_again,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = (requireActivity().application as LemonJuiceApp).viewModel

        binding.actionButton.setOnClickListener {
            viewModel.goAgain()
            (requireActivity() as GlassNavigation).navigateToTree()
        }
    }
}

interface GlassNavigation{
    fun navigateToTree()
}