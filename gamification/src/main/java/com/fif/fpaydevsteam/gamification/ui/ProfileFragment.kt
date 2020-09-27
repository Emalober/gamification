package com.fif.fpaydevsteam.gamification.ui

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fif.fpaydevsteam.gamification.R
import com.fif.fpaydevsteam.gamification.utils.MAX_EXPERIENCE_BY_LEVEL
import com.fif.fpaydevsteam.gamification.utils.Resource
import kotlinx.android.synthetic.main.profile_gamification_fragment.*

class ProfileFragment : Fragment(R.layout.profile_gamification_fragment)  {

    private val gamificationViewModel: GamificationViewModel by navGraphViewModels(R.id.nav_graph_gamification)

    private lateinit var objAdapter: ObjectiveAdapter
    private var animOpenModal: Animation? = null
    private var animCloseModal: Animation? = null
    private var animBlur: Animation? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecycleView()

        gamificationViewModel.userInfo.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    userNameTextView.text = "${it.data?.firstName} ${it.data?.lastSurname}"
                    userNameTextView.text = "Homero Thompson"
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
                    val logros = it.data?.map { ar -> ObjectiveModel(ar.description, 20, "200 Exp") }
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
                    val lv = it.data?.ranking?.plus(1)?:0
                    levelTextView.text = "Nivel ${ lv + 1 }"
                    nextLevelProgressBar.progress = it.data?.experience?.let { xp -> (xp-MAX_EXPERIENCE_BY_LEVEL*lv)/MAX_EXPERIENCE_BY_LEVEL*100}?:0
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    Toast.makeText(requireActivity(), "Cargando...", Toast.LENGTH_SHORT).show()
            }
        })

        animOpenModal = AnimationUtils.loadAnimation(requireContext(), R.anim.modal_open_anim)
        animCloseModal = AnimationUtils.loadAnimation(requireContext(), R.anim.modal_close_anim)
        animBlur = AnimationUtils.loadAnimation(requireContext(), R.anim.modal_blur_anim)
        closeOpenMiniGame()

        gamificationViewModel.hasChanceToPlay.observe(viewLifecycleOwner, Observer {
            if(it) startOpenMiniGame()
        })

        giftBoxImageButton.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_modalFragment)
        }

        closeTextButton.setOnClickListener {
            closeOpenMiniGame()
        }

        promotionCardView.setOnClickListener {
            findNavController().navigate(R.id.action_global_easter_egg)

            //findNavController().navigate(R.id.action_profileFragment_to_awardsFragment)
        }

        nextLevelCardView.setOnClickListener {
           // findNavController().navigate(R.id.action_global_easter_egg)

            //findNavController().navigate(Uri.parse(getString(R.string.deep_link_easter_egg)))
        }
    }

    private fun startOpenMiniGame() {
        blurMiniGameModal.visibility = View.VISIBLE

        miniGameModal.alpha = 1f
        blurMiniGameModal.alpha = 0.7f

        miniGameModal.startAnimation(animOpenModal)
        blurMiniGameModal.startAnimation(animBlur)
    }

    private fun closeOpenMiniGame() {
        miniGameModal.alpha = 0f
        blurMiniGameModal.alpha = 0f
        miniGameModal.startAnimation(animOpenModal)
        blurMiniGameModal.startAnimation(animBlur)
        blurMiniGameModal.visibility = View.GONE
        miniGameModal.visibility = View.GONE
    }

    private fun setupRecycleView() = objectivesList.apply {
        objAdapter = ObjectiveAdapter()
        adapter = objAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}