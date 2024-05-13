package com.example.lemonjuice.presentation.tree

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R
import com.example.lemonjuice.presentation.core.AbstractFragment
import com.example.lemonjuice.presentation.core.ManageViewModels

class TreeFragment : AbstractFragment(
    imageResId = R.drawable.ic_tree,
    descResId = R.string.tree,
    actionTextResId = R.string.pick,
    hintResId = R.string.click_pick,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val manageViewModels = activity as ManageViewModels
        val viewModel = manageViewModels.viewModel(TreeViewModel::class.java)
        viewModel.init()

        binding.actionButton.setOnClickListener {
            (requireActivity() as TreeNavigation).navigateToLemon()
        }
    }
}

interface TreeNavigation {
    fun navigateToLemon()
}
