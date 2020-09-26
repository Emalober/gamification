package com.fif.fpaydevsteam.gamification.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fif.fpaydevsteam.gamification.R
import kotlinx.android.synthetic.main.item_progress_bar.view.*

class ObjectiveAdapter : RecyclerView.Adapter<ObjectiveAdapter.ObjectiveViewHolder>()  {

    inner class ObjectiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectiveViewHolder {
        return ObjectiveViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_progress_bar,
                parent,
                false
            )
        )    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: ObjectiveViewHolder, position: Int) {
        //val run = differ.currentList[position]
        holder.itemView.apply {
            titleTextView.text = "Reto por definir"
            progressBar.progress = 30
            maxValueTextView.text = "500 P"
        }
    }

}
