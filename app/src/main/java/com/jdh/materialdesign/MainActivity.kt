package com.jdh.materialdesign

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
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

        itemList.add(RecyclerItem("App bars: top"))
        itemList.add(RecyclerItem("Bottom navigation"))

        val recyclerDesignAdapter = RecyclerDesignAdapter(itemList, this)
        recyclerDesignAdapter.notifyDataSetChanged()

        // recyclerview 클릭이벤트
        recyclerDesignAdapter.setItemClickListener(object: RecyclerDesignAdapter.AAAAClickListener{
            override fun onClick(v: View, position: Int) {
                when (position) {
                    0 -> startActivity(Intent(v.context, AppBarsTopActivity::class.java))
                    1 -> startActivity(Intent(v.context, BottomNavigation::class.java))
                }
            }
        })

        RecyclerView_design.adapter = recyclerDesignAdapter
        RecyclerView_design.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        statusHeight = statusBarHeight()
        navigationHeight = navigationHeight()

    }

    // 상태바 높이 구해서 padding 적용하기
    fun statusBarHeight(): Int {
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")

        return if (resourceId > 0) resources.getDimensionPixelSize(resourceId)
        else 0
    }

    // 하단의 네비게이션바(안드 뒤로가기) 높이 구하기. 하단 padding 적용하기
    fun navigationHeight(): Int {
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")

        return if (resourceId > 0) resources.getDimensionPixelSize(resourceId)
        else 0
    }

    companion object {
        // const가 붙으면 런타임이 아니라 컴파일때 초기화가 됨.
        var statusHeight: Int = 0
        var navigationHeight: Int = 0

        fun setStatusBarTransparent(context: AppCompatActivity) {
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
//    companion object fun setStatusBarTransparent(context: AppCompatActivity) {
//        context.window.apply {
//            setFlags(
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//            )
//        }
//        if(Build.VERSION.SDK_INT >= 30) {	// API 30 에 적용
//            WindowCompat.setDecorFitsSystemWindows(context.window, false)
//        }
//    }
}