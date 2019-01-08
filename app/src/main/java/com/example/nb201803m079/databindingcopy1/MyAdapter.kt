package com.example.nb201803m079.databindingcopy1

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nb201803m079.databindingcopy1.databinding.ItemViewBinding

//importしてる元が違ったりしたので、比べてみて！
class MyAdapter(private var dataList: List<MyData>) : RecyclerView.Adapter<MyAdapter.BindingHolder>() {

    private lateinit var listener: OnItemClickListener

    //Adapterの引数とかの構成がちょっと古かったのと、自動変換でp01とかになってたので変えました
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        setOnItemClickListener(listener)
        //!!よりrequireNotNull使おう
        val layoutInflater = LayoutInflater.from(requireNotNull(parent).context)
        val binding = ItemViewBinding.inflate(layoutInflater, parent, false)
        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val data = dataList[position]
        //setDataはこれでOK
        holder.binding.data = data
        holder.binding.originalLinearLayout.setOnClickListener {
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