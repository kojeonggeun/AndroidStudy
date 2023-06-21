package com.example.networkstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SubwayAdapter(private val items: List<RealtimeArrivalList>): RecyclerView.Adapter<SubwayAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val arvlMsg2: TextView = itemView.findViewById(R.id.arvlMsg2)
        val arvlMsg3: TextView = itemView.findViewById(R.id.arvlMsg3)
        val updnLine: TextView = itemView.findViewById(R.id.updnLine)
        val trainLineNm: TextView = itemView.findViewById(R.id.trainLineNm)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_list, parent, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.arvlMsg2.text = item.arvlMsg2
        holder.arvlMsg3.text = item.arvlMsg3
        holder.updnLine.text = item.updnLine
        holder.trainLineNm.text = item.trainLineNm
    }
}