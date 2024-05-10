package com.example.lemonjuice.presentation

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R

class TreeFragment : AbstractFragment(
    imageResId = R.drawable.ic_tree,
    descResId = R.string.tree,
    actionTextResId = R.string.pick,
    hintResId = R.string.click_pick,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(LemonFragment())
        }
    }
}
