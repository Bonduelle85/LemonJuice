package com.example.lemonjuice.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lemonjuice.R
import com.example.lemonjuice.databinding.FragmentMainBinding

class JuiceFragment : AbstractFragment(
    actionImageButtonImageResId = R.drawable.ic_juice,
    actionImageButtonDescResId = R.string.juice,
    actionButtonTextResId = R.string.drink,
    hintTextViewTextResId = R.string.click_drink,
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionButton.setOnClickListener {
            (requireActivity() as Navigation).navigate(GlassFragment())
        }
    }

}