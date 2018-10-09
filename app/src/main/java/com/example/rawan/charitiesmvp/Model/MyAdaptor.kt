package com.example.rawan.charitiesmvp.Model

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rawan.charitiesmvp.Model.APICall.CharitiesData
import com.example.rawan.charitiesmvp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content.view.*

/**
 * Created by rawan on 08/10/18.
 */
class MyAdaptor(private var allData: List<CharitiesData>, val clickListener:(CharitiesData)->Unit) : RecyclerView.Adapter<MyAdaptor.CharitiesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CharitiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.content,parent,false)
        return CharitiesViewHolder(view)
    }
    override fun getItemCount(): Int =allData.size
    override fun onBindViewHolder(holder: CharitiesViewHolder, postion: Int) {
            val allDataPosition=allData[postion]
            holder.itemView.tvOrganizationName.append(allDataPosition.organization_name)
            holder.itemView.tvOrganizationType.append(allDataPosition.organization_type)
            holder.itemView.tvOrganizationDesc.append(allDataPosition.organization_desc)
            Picasso.get().load(allDataPosition.organization_pic).fit().centerCrop().into(holder.itemView.IvIcon)
            holder.bind(allDataPosition,clickListener)
    }
    class CharitiesViewHolder(v: View) : RecyclerView.ViewHolder(v){
        fun bind(charitiesData: CharitiesData, clickListener: (CharitiesData) -> Unit){
            itemView.setOnClickListener { clickListener(charitiesData) }
        }
    }
}