package com.annaginagili.avengers

import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(private val context: Context, private val itemList: ArrayList<AdapterItem>) :
    RecyclerView.Adapter<RecyclerAdapter.AdapterHolder>() {

    class AdapterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.name)
        private val realName = itemView.findViewById<TextView>(R.id.realName)
        private val team = itemView.findViewById<TextView>(R.id.team)
        private val first = itemView.findViewById<TextView>(R.id.firstAppearance)
        private val createdBy = itemView.findViewById<TextView>(R.id.createdBy)
        private val publisher = itemView.findViewById<TextView>(R.id.publisher)
        private val image = itemView.findViewById<ImageView>(R.id.image)
        private val bio = itemView.findViewById<TextView>(R.id.bio)
        fun setData(context:Context, item: AdapterItem, itemList: ArrayList<AdapterItem>) {
            this.name.text = item.name
            this.realName.text = item.realName
            this.team.text = item.team
            this.first.text = item.firstAppearance
            this.createdBy.text = item.createdBy
            this.publisher.text = item.publisher
            this.bio.text = item.bio
            Glide.with(context).load(item.imageUrl).into(this.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.adapter_layout, parent, false)
        return AdapterHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: AdapterHolder, position: Int) {
        val item: AdapterItem = itemList[position]
        holder.setData(context, item, itemList)
    }
}