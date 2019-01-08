package com.example.nb201803m079.databindingcopy1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<MyData>()
        for (i in 0..99) {
            list.add(MyData(i.toString()))
        }

        val adapter = MyAdapter(list)

        //bindingレイアウトにする意味ないので変えてみた
        this.recyclerView.adapter = adapter

        //RecyclerViewにlayoutManagerが必要！
        this.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun onClick(view: View, data: MyData) {
                Toast.makeText(applicationContext, data.name, Toast.LENGTH_SHORT).show()
            }
        })

    }
}
