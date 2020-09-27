package com.fif.fpaydevsteam.gamification.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.fif.fpaydevsteam.gamification.R
import com.fif.fpaydevsteam.gamification.utils.Resource
import kotlinx.android.synthetic.main.fragment_easter_egg.*
import kotlinx.android.synthetic.main.fragment_easter_egg.animationView

class EasterEggFragment : Fragment(R.layout.fragment_easter_egg) {

    private val gamificationViewModel: GamificationViewModel by navGraphViewModels(R.id.nav_graph_gamification)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gamificationViewModel.awardes.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    gamificationViewModel.createEasterEgg()
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    Toast.makeText(requireActivity(), "Buscando entre los pastos", Toast.LENGTH_SHORT).show()
            }
        })

        gamificationViewModel.hasAPrize.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.type.contentEquals("exp")) {
                    animationView.setAnimation(R.raw.egg_first)
                    awardTextView.text = "No encontraste nada"
                    infoTextView.text = "Pero igual ganaste ${it.description}"
                } else {
                    awardTextView.text = "Felicitaciones!!"
                    infoTextView.text = "Ganaste ${it.description}"
                    animationView.repeatCount = 1
                    animationView.setAnimation(R.raw.bunny_egg_easter)
                }
                animationView.playAnimation()
            }?:findNavController().navigateUp()
        })

    }
}
