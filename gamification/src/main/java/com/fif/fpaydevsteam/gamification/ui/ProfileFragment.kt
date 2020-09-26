package com.fif.fpaydevsteam.gamification.ui

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fif.fpaydevsteam.gamification.R
import kotlinx.android.synthetic.main.profile_gamification_fragment.*

class ProfileFragment : Fragment(R.layout.profile_gamification_fragment)  {

    private lateinit var objAdapter: ObjectiveAdapter

    private fun setupRecycleView() = objectivesList.apply {
        objAdapter = ObjectiveAdapter()
        adapter = objAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}