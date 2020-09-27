package com.fif.fpaydevsteam.gamification.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.fif.fpaydevsteam.gamification.R
import kotlinx.android.synthetic.main.fragment_awards.*

class AwardsFragment : Fragment(R.layout.fragment_awards) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dummyImageView.setOnClickListener {
            findNavController().navigate(R.id.action_global_gamification)
        }
    }
}
