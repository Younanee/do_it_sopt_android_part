package com.sopt_nyh.sub_seminar002_example

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstFragment : Fragment(){
    companion object {
        private var instance : FirstFragment? = null
        fun getInstance(): FirstFragment {
            if (instance == null) {
                instance = FirstFragment()
            }
            return instance!!
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }
}