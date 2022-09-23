package com.example.androidarchitecturedemo.mvvm_demo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidarchitecturedemo.databinding.ItemMvvmLayoutBinding
import com.example.androidarchitecturedemo.diffutil_list_adapter.DiffUtillAndListAdapter

class MVVMAdapter(private val  mlist:List<MVVMQuotesDataClass>) : RecyclerView.Adapter<MVVMAdapter.MVVMViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVVMViewHolder {
        val view = ItemMvvmLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MVVMViewHolder(view)
    }

    override fun onBindViewHolder(holder: MVVMViewHolder, position: Int) {
        val modal = mlist[position]
        holder.bind(modal)
    }

    override fun getItemCount(): Int {
            return mlist.size
    }

    class MVVMViewHolder(val binding: ItemMvvmLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(modal: MVVMQuotesDataClass){
            binding.modal = modal
        }
    }
}