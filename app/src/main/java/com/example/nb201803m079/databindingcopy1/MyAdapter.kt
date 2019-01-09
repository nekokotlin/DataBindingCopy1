package com.example.nb201803m079.databindingcopy1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nb201803m079.databindingcopy1.databinding.ItemViewBinding

class MyAdapter(private var dataList: List<MyData>) : RecyclerView.Adapter<MyAdapter.BindingHolder>(){

        private lateinit var listener: OnItemClickListener

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        setOnItemClickListener(listener)
        val layoutInflater = LayoutInflater.from(requireNotNull(parent).context)
        val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return MyAdapter.BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val data = dataList[position]
        holder.binding.data = data
        holder.binding.originalLinearLayout.setOnClickListener{
            listener.onClick(it, data)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    interface OnItemClickListener {
        fun onClick(view: View, data: MyData)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class BindingHolder(var binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

}