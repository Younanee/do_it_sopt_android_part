package com.sopt_nyh.seminar_001

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setClickListener()

    }


    private fun setClickListener(){
        btn_main_act_part_ok.setOnClickListener {
            var mPartName : String = et_main_act_what_is_your_part.text.toString()
            et_main_act_what_is_your_part.text.clear()
            toast(mPartName)
            //Toast.makeText(this,"안녕", Toast.LENGTH_SHORT)
        }
    }



}
