package com.fif.fpaydevsteam.gamification.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fif.fpaydevsteam.gamification.R
import kotlinx.android.synthetic.main.item_progress_bar.view.*

data class ObjectiveModel(val title: String, val progress: Int, val reward: String)

class ObjectiveAdapter : RecyclerView.Adapter<ObjectiveAdapter.ObjectiveViewHolder>()  {

    inner class ObjectiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<ObjectiveModel>() {
        override fun areItemsTheSame(oldItem: ObjectiveModel, newItem: ObjectiveModel): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: ObjectiveModel, newItem: ObjectiveModel): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<ObjectiveModel>) = differ.submitList(list)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObjectiveViewHolder {
        return ObjectiveViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_progress_bar,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ObjectiveViewHolder, position: Int) {
        holder.itemView.apply {
            titleTextView.text = differ.currentList[position].title
            progressBar.progress = differ.currentList[position].progress
            maxValueTextView.text = differ.currentList[position].reward
        }
    }

}
