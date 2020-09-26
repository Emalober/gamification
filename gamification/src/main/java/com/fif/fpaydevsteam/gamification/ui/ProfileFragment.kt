package com.fif.fpaydevsteam.gamification.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.fif.fpaydevsteam.gamification.R
import kotlinx.android.synthetic.main.profile_gamification_fragment.*

class ProfileFragment : Fragment(R.layout.profile_gamification_fragment)  {

    private lateinit var objAdapter: ObjectiveAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycleView()

        val logros = listOf(ObjectiveModel("Pagar 5 veces con Fpay", 20, "200 Exp"),
                            ObjectiveModel("Referir a 5 amigos", 60, "500 Exp"),
                            ObjectiveModel("Visita la nueva tienda", 0, "200 P.CMR"))

        objAdapter.submitList(logros)
    }

    private fun setupRecycleView() = objectivesList.apply {
        objAdapter = ObjectiveAdapter()
        adapter = objAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}