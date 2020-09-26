package com.fif.fpaydevsteam.gamification.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fif.fpaydevsteam.gamification.R
import com.fif.fpaydevsteam.gamification.utils.Resource
import kotlinx.android.synthetic.main.profile_gamification_fragment.*

class ProfileFragment : Fragment(R.layout.profile_gamification_fragment)  {

    private val gamificationViewModel: GamificationViewModel by navGraphViewModels(R.id.nav_graph_gamification)

    private lateinit var objAdapter: ObjectiveAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycleView()

        val logros = listOf(ObjectiveModel("Pagar 5 veces con Fpay", 20, "200 Exp"),
                            ObjectiveModel("Referir a 5 amigos", 60, "500 Exp"),
                            ObjectiveModel("Visita la nueva tienda", 0, "200 P.CMR"))

        objAdapter.submitList(logros)

        gamificationViewModel.userInfo.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Toast.makeText(requireActivity(), it.data?.firstName, Toast.LENGTH_LONG).show()
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    Toast.makeText(requireActivity(), "Cargando...", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setupRecycleView() = objectivesList.apply {
        objAdapter = ObjectiveAdapter()
        adapter = objAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}