package com.sopt_nyh.sub_seminar002_example.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sopt_nyh.sub_seminar002_example.R
import kotlinx.android.synthetic.main.fragment_first2.*

class FirstFragment2 : Fragment() {

    companion object {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Bundle을 통해서 데이터 전달 받을때 받는곳.
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //뷰를 붙이는 곳(우리가 만든 layout 파일을 붙이는 곳)
        val view : View = inflater.inflate(R.layout.fragment_first2, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //우리가 붙인 뷰를 마음껏 컨트롤하는 곳.

        tv_first_fragment_title.text = "안녕하세요!"
    }

}

