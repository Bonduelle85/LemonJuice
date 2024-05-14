package com.example.lemonjuice.tree.presentation

import android.os.Bundle
import android.view.View
import com.example.lemonjuice.R
import com.example.lemonjuice.core.presentation.AbstractFragment
import com.example.lemonjuice.core.di.ManageViewModels

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

        if (savedInstanceState == null) viewModel.init()

        binding.actionButton.setOnClickListener {
            manageViewModels.clear(TreeViewModel::class.java)
            (requireActivity() as TreeNavigation).navigateToLemon()
        }
    }
}

interface TreeNavigation {
    fun navigateToLemon()
}
