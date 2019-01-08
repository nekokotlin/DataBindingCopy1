package com.example.nb201803m079.databindingcopy1

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView


class MyAdapter(var dataList: List<MyData>) : RecyclerView.Adapter<MyAdapter.BindingHolder>{
    lateinit var listener: AdapterView.OnItemClickListener


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyAdapter.BindingHolder? {
        setOnItemClickListener(listener)
        val layoutInflater = LayoutInflater.from(parent!!.context)
        val binding = OriginalItemLayoutBinding.inflate(layoutInflater, parent, false)
        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val data = dataList[position]
        holder.binding.setData(data)
        holder.binding.originalLinearLayout.setOnClickListener({
            listener.onClick(it, data)
        })
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

    class BindingHolder(var binding: OriginalItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)


}