package com.example.lemonjuice.presentation.juice

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R
import com.example.lemonjuice.presentation.core.AbstractFragment

class JuiceFragment : AbstractFragment(
    imageResId = R.drawable.ic_juice,
    descResId = R.string.juice,
    actionTextResId = R.string.drink,
    hintResId = R.string.click_drink,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            (requireActivity() as JuiceNavigation).navigateToGlass()
        }
    }
}

interface JuiceNavigation{
    fun navigateToGlass()
}