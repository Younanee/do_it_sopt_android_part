package com.sopt_nyh.sub_seminar002_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        iv_main_act_user_picture.setOnClickListener {
            startActivity<SubActivity>()
        }
    }
}

/*
하승완, 이소희, 양승희, 김무현, 송지현, 제갈은, 이하은, 방수정
 */