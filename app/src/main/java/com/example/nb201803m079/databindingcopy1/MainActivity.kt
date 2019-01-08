package com.example.nb201803m079.databindingcopy1

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<MyData>()
        for (i in 0..99) {
            list.add(MyData(i.toString()))
        }

        val adapter = MyAdapter(list)
        val binding = DataBindingUtil.setContentView<ItemViewBinding>(this, R.layout.activity_main)

        binding.recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onClick(view: View, data: MyData) {
                Toast.makeText(applicationContext, data.name, Toast.LENGTH_LONG).show()
            }
        })

    }
}
