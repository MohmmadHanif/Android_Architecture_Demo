package com.example.androidarchitecturedemo.diffutil_list_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecturedemo.R

class DiffUtillAndListAdapter() :
    ListAdapter<deffUtilsDataClass, DiffUtillAndListAdapter.viewHolder>(deffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diffutil_and_listadapter_layout,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val modal = getItem(position)
        holder.bind(modal)
    }

    class deffUtil : DiffUtil.ItemCallback<deffUtilsDataClass>() {
        override fun areItemsTheSame(
            oldItem: deffUtilsDataClass,
            newItem: deffUtilsDataClass,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: deffUtilsDataClass,
            newItem: deffUtilsDataClass,
        ): Boolean {
            return oldItem == newItem
        }
    }

    class viewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.diffUtilDemoName)
        val phone = view.findViewById<TextView>(R.id.diffUtilDemoNumber)

        fun bind(modal : deffUtilsDataClass){
            name.text = modal.name
            phone.text = modal.phonenumber
        }
    }

}