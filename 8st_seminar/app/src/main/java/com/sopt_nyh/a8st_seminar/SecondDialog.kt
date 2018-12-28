package com.sopt_nyh.a8st_seminar

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import kotlinx.android.synthetic.main.dialog_second.*

class SecondDialog(val ctx : Context) : AlertDialog(ctx){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_second)

        setOnBtnClickListener()
    }

    private fun setOnBtnClickListener(){
        btn_second_dialog_ok.setOnClickListener {
            if (ctx is MainActivity){
                ctx.showMainActToastMessage()
            }
            dismiss()
        }
    }
}