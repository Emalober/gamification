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

        gamificationViewModel.userInfo.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    userNameTextView.text = "${it.data?.firstName} ${it.data?.lastSurname}"
                    Toast.makeText(requireActivity(), it.data?.firstName, Toast.LENGTH_LONG).show()
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    Toast.makeText(requireActivity(), "Cargando...", Toast.LENGTH_SHORT).show()
            }
        })

        gamificationViewModel.achievements.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    val logros = it.data?.achievements?.map { ar -> ObjectiveModel(ar.description, 20, "200 Exp") }
                    logros?.let { it1 -> objAdapter.submitList(it1) }
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    Toast.makeText(requireActivity(), "Cargando...", Toast.LENGTH_SHORT).show()
            }
        })

        gamificationViewModel.userRegister.observe(viewLifecycleOwner, Observer { it ->
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    cmrPointsTextView.text = it.data?.points?.quantity.toString()?:"¯\\_(ツ)_/¯"
                    levelTextView.text = "Nivel ${it.data?.ranking}"
                    nextLevelProgressBar.progress = it.data?.experience?.let { ex -> ex }?:0
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