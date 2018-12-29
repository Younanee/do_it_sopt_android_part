package com.sopt_nyh.a8st_seminar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(MyFragment.getInstance("안녕하세요!", "안드로이드 파트장 남윤환입니다."))
        setOnBtnClickListener()
    }
//
    private fun addFragment(fragment : Fragment){
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_main_act_fragment, fragment)
        transaction.commit()
    }

    private fun setOnBtnClickListener(){
        btn_main_act_show_first_dialog.setOnClickListener {
            val firstDialog : FirstDialogFragment = FirstDialogFragment()
            firstDialog.show(supportFragmentManager, "first dialog")
        }

        btn_main_act_show_second_dialog.setOnClickListener {
            val secondDialog : SecondDialog = SecondDialog(this)
            secondDialog.show()
        }
    }

    fun showMainActToastMessage(){
        toast("메인 엑티비티 함수 호출")
    }
}




