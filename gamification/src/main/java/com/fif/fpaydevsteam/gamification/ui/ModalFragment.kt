package com.fif.fpaydevsteam.gamification.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.fif.fpaydevsteam.gamification.R
import kotlinx.android.synthetic.main.fragment_modal.*
import kotlin.random.Random

class ModalFragment : Fragment(R.layout.fragment_modal) {

    private val gamificationViewModel: GamificationViewModel by navGraphViewModels(R.id.nav_graph_gamification)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gamificationViewModel.hasChanceToPlay.observe(viewLifecycleOwner, Observer {
            if(it) {
                if (Random.nextInt(0, 10) < 1) {
                    animationView.setAnimation(R.raw.indian_money_surprise)
                    animationView.repeatCount = 1
                    miniGameTextView.text = "Ganaste un dia de Homeoffice"
                } else {
                    miniGameTextView.text = "Mejor suerte la próxima"
                    animationView.setAnimation(R.raw.sad_face)
                }
                gamificationViewModel.hasChanceToPlay.value = false
            }
            animationView.playAnimation()
        })

    }
}
