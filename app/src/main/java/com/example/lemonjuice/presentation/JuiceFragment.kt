package com.example.lemonjuice.presentation

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R

class JuiceFragment : AbstractFragment(
    imageResId = R.drawable.ic_juice,
    descResId = R.string.juice,
    actionTextResId = R.string.drink,
    hintResId = R.string.click_drink,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(GlassFragment())
        }
    }

}