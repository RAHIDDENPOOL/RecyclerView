package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ChanitemBinding

class ChanAdapter: RecyclerView.Adapter<ChanAdapter.ChanHolder>() {
    val chanList = ArrayList<Girls>()
    class ChanHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ChanitemBinding.bind(item)
        fun bind(girls: Girls) = with(binding){
            im.setImageResource(girls.imageId)
            txtTittle.text = girls.EdTitle

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChanHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chanitem,parent,false)
        return ChanHolder(view)
    }

    override fun onBindViewHolder(holder: ChanHolder, position: Int) {
        holder.bind(chanList[position])
    }

    override fun getItemCount(): Int {
        return chanList.size
    }

    fun addChan(girls: Girls){
        chanList.add(girls)
        notifyDataSetChanged()
    }
}