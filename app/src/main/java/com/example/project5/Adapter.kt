package com.example.project5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SleepDataAdapter(private val sleepDataList: List<SleepData>) : RecyclerView.Adapter<SleepDataAdapter.SleepDataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepDataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_sleep_data, parent, false)
        return SleepDataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SleepDataViewHolder, position: Int) {
        val currentItem = sleepDataList[position]
        holder.dateTextView.text = currentItem.date
        holder.timeTextView.text = currentItem.duration
        holder.qualityTextView.text = currentItem.quality
    }

    override fun getItemCount(): Int {
        return sleepDataList.size
    }

    class SleepDataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val qualityTextView: TextView = itemView.findViewById(R.id.qualityTextView)
    }
}
