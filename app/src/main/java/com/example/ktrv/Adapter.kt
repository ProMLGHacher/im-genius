package com.example.ktrv

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.ktrv.databinding.ViewHolderBinding


class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    val list = ArrayList<DataClass>()

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ViewHolderBinding.bind(item)
        fun bind(dataClass: DataClass) = with(binding) {
            intTV.text = dataClass.int.toString()
            stringTV.text = dataClass.string
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(dataClass: DataClass) {
        list.add(dataClass)
        notifyDataSetChanged()
    }

}