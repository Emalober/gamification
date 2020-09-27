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
                awardTextView.text = "Felicitaciones!!"
                infoTextView.text = "Ganaste ${it.description}"
                if (it.type.contentEquals("exp")) {
                    gamificationViewModel.addPoints(500)
                }

                animationView.addAnimatorUpdateListener { valueAnimator ->
                    if(valueAnimator.animatedFraction > 0.8) {
                        infoTextView.visibility = View.VISIBLE
                        awardTextView.visibility = View.VISIBLE
                    }
                }
            }
        })

        animationView.setOnClickListener {
            findNavController().navigate(R.id.action_easterEggFragment_to_awardsFragment)
        }
    }
}
