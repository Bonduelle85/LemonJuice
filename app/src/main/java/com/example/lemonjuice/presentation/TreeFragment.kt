package com.example.lemonjuice.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonjuice.R
import com.example.lemonjuice.databinding.FragmentMainBinding

class TreeFragment : AbstractFragment(
    actionImageButtonImageResId = R.drawable.ic_tree,
    actionImageButtonDescResId = R.string.tree,
    actionButtonTextResId = R.string.pick,
    hintTextViewTextResId = R.string.click_pick,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(LemonFragment())
        }
    }
}
