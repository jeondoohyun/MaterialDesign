package com.jdh.materialdesign

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationBarView.OnItemReselectedListener
import com.jdh.materialdesign.databinding.ActivityBottomNavigationBinding

class BottomNavigation : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityBottomNavigationBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_bottom_navigation)
        mBinding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MainActivity.setStatusBarTransparent(this)
        binding.container.setPadding(0, 0,0, MainActivity.navigationHeight) // setStatusBarTransparent()를 적용하면 상태바 뿐만아니라 네비게이션바 까지 확장되어 아래에 패딩을 줘야한다.

        // todo : fragment로 네비게이션 바텀에 따른 각 화면 추가 하기, 아이콘에 숫자뱃지 추가해보기

//        var bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)


        binding.bottomNavigation.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.favorite -> {
                        Toast.makeText(this@BottomNavigation, "favo",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.music -> {
                        Toast.makeText(this@BottomNavigation, "music",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.place -> {
                        Toast.makeText(this@BottomNavigation, "place",Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.news -> {
                        Toast.makeText(this@BottomNavigation, "news",Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> false
                }
                return true
            }
        })

//        binding.bottomNavigation.setOnItemReselectedListener(object : OnItemReselectedListener {
//            override fun onNavigationItemReselected(item: MenuItem) {
//                when (item.itemId) {
//                    R.id.favorite -> {
//                        Toast.makeText(this@BottomNavigation, "favo", Toast.LENGTH_SHORT).show()
//                    }
//
//                    R.id.music -> {
//                        Toast.makeText(this@BottomNavigation, "music", Toast.LENGTH_SHORT).show()
//                    }
//
//                    R.id.place -> {
//                        Toast.makeText(this@BottomNavigation, "place", Toast.LENGTH_SHORT).show()
//                    }
//
//                    R.id.news -> {
//                        Toast.makeText(this@BottomNavigation, "news", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        })





    }


}