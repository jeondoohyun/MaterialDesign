package com.jdh.materialdesign

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 화면을 상태바까지 확장
        setStatusBarTransparent(this)

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

    companion object fun setStatusBarTransparent(context: AppCompatActivity) {
        context.window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        if(Build.VERSION.SDK_INT >= 30) {	// API 30 에 적용
            WindowCompat.setDecorFitsSystemWindows(context.window, false)
        }
    }
}