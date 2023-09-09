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
import com.jdh.materialdesign.fragment.FragmentFavorite
import com.jdh.materialdesign.fragment.FragmentMusic
import com.jdh.materialdesign.fragment.FragmentNews
import com.jdh.materialdesign.fragment.FragmentPlace

class BottomNavigation : AppCompatActivity() {
    // 전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityBottomNavigationBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    private val fragmentFavorite = FragmentFavorite()
    private val fragmentMusic = FragmentMusic()
    private val fragmentPlace = FragmentPlace()
    private val fragmentNews = FragmentNews()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MainActivity.setStatusBarTransparent(this)
        binding.container.setPadding(0, 0,0, MainActivity.navigationHeight) // setStatusBarTransparent()를 적용하면 상태바 뿐만아니라 네비게이션바 까지 확장되어 아래에 패딩을 줘야한다.

        // todo : fragment로 네비게이션 바텀에 따른 각 화면 추가 하기, 아이콘에 숫자뱃지 추가해보기

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout, fragmentFavorite)
        transaction.commit()

        // 뱃지
        var badge_favo = binding.bottomNavigation.getOrCreateBadge(R.id.favorite)
        badge_favo.isVisible = true
        badge_favo.number = 10

        var badge_music = binding.bottomNavigation.getOrCreateBadge(R.id.music)
        badge_music.isVisible = true
        badge_music.number = 3


        binding.bottomNavigation.setOnItemSelectedListener(object : NavigationBarView.OnItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {

                when(item.itemId){
                    R.id.favorite -> {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.frameLayout, fragmentFavorite)
                        transaction.commit()
                        if (badge_favo != null) {
                            badge_favo.isVisible = false
                            badge_favo.clearNumber()
                        }
                        true
                    }
                    R.id.music -> {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.frameLayout, fragmentMusic)
                        transaction.commit()
                        if (badge_music != null) {
                            badge_music.isVisible = false
                            badge_music.clearNumber()
                        }
                        true
                    }
                    R.id.place -> {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.frameLayout, fragmentPlace)
                        transaction.commit()
                        true
                    }
                    R.id.news -> {
                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.frameLayout, fragmentNews)
                        transaction.commit()
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

    fun openFragmentOnFrameLayoutB(int: Int){
        val transaction = supportFragmentManager.beginTransaction()
        when(int){
            1 -> transaction.replace(R.id.frameLayout, fragmentFavorite)
            2 -> transaction.replace(R.id.frameLayout, fragmentMusic)
            3 -> transaction.replace(R.id.frameLayout, fragmentPlace)
            4 -> transaction.replace(R.id.frameLayout, fragmentNews)
        }
        transaction.commit()
    }


}