package com.sopt_nyh.sub_seminar002_example

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        addFragment(FirstFragment())

        setOnClickListener()

    }

    private fun setOnClickListener() {
        btn_sub_act_first.setOnClickListener {
            replaceFragment(FirstFragment())
        }
        btn_sub_act_second.setOnClickListener {
            replaceFragment(SecondFragment())
        }
    }


    private fun addFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_sub_act_fragment, fragment)
        transaction.commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_sub_act_fragment, fragment)
        transaction.commit()
    }
}
