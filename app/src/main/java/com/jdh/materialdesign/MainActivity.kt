package com.jdh.materialdesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val RecyclerView_design = findViewById<RecyclerView>(R.id.RecyclerView_design)

        val itemList = ArrayList<RecyclerItem>()

        itemList.add(RecyclerItem("App bars: top", "AppBarsTopActivity"))

        val recyclerDesignAdapter = RecyclerDesignAdapter(itemList, this)
        recyclerDesignAdapter.notifyDataSetChanged()

        recyclerDesignAdapter.setItemClickListener(object: RecyclerDesignAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                when (position) {
                    0 -> startActivity(Intent(v.context, AppBarsTopActivity::class.java))
                }
            }
        })

        RecyclerView_design.adapter = recyclerDesignAdapter
        RecyclerView_design.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)



    }
}