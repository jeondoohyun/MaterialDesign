package com.jdh.materialdesign

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar

class AppBarsTopActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app_bars_top)

        // status상태바 까지 appbar가 자리를 침범한다. status높이 만큼 padding을 줘야함
        MainActivity().setStatusBarTransparent(this)

        var topAppBar = findViewById<MaterialToolbar>(R.id.topAppBar)

        // 상태바 만큼 padding줘서 상태바 아래에 appbar 깔끔하게 나오게 하기
        topAppBar.setPadding(
            0,
            statusBarHeight(),
            0,
            0
        )

        topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "navi",Toast.LENGTH_SHORT).show()
        }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    Toast.makeText(this, "favo",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, "search",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.more -> {
                    Toast.makeText(this, "more",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }

    // 상태바 높이 구해서 padding 적용하기
    fun statusBarHeight(): Int {
        val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")

        return if (resourceId > 0) resources.getDimensionPixelSize(resourceId)
        else 0
    }

}