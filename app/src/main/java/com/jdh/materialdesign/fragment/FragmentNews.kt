package com.jdh.materialdesign.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jdh.materialdesign.BottomNavigation
import com.jdh.materialdesign.databinding.FragmentFavoriteBinding
import com.jdh.materialdesign.databinding.FragmentNewsBinding


class FragmentNews : Fragment() {

    private var _binding : FragmentNewsBinding? = null
    private val binding get() = _binding!!

    var bottomNavigation: BottomNavigation? = null

    // fragment에서 context 파라미터 받아서 쓰기
    override fun onAttach(context: Context) {
        super.onAttach(context)
        bottomNavigation = context as BottomNavigation
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)

//        binding..setOnClickListener {
//            mainActivity!!.openFragmentOnFrameLayoutB(1)
//        }
//
//        binding.btnShowFragmentC.setOnClickListener {
//            mainActivity!!.openFragmentOnFrameLayoutB(2)
//        }

        return binding.root
    }
}