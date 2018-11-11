package com.sopt_nyh.sub_seminar002_example.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.sopt_nyh.sub_seminar002_example.MainFragment
import com.sopt_nyh.sub_seminar002_example.MapFragment
import com.sopt_nyh.sub_seminar002_example.MyPageFragment

class MyFragmentSPAdapter(fm : FragmentManager, val fCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return MainFragment()
            1 -> {
                val mapFragment : Fragment = MapFragment()
                return mapFragment
            }
            2 -> return MyPageFragment()
            else -> return null
        }
    }

    override fun getCount(): Int = fCount
}