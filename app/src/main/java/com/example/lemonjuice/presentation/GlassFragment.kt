package com.example.lemonjuice.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonjuice.LemonJuiceApp
import com.example.lemonjuice.R
import com.example.lemonjuice.databinding.FragmentMainBinding

class GlassFragment : AbstractFragment(
    actionImageButtonImageResId = R.drawable.ic_empty_glass,
    actionImageButtonDescResId = R.string.glass,
    actionButtonTextResId = R.string.again,
    hintTextViewTextResId = R.string.click_again,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = (requireActivity().application as LemonJuiceApp).viewModel

        binding.actionButton.setOnClickListener {
            viewModel.goAgain()
            (requireActivity() as Navigation).navigate(TreeFragment())
        }
    }
}