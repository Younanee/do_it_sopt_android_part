package com.sopt_nyh.a8st_seminar

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.dialog_first.*

class FirstDialogFragment : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.dialog_first, container, false)
        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_first_dialog_ok.setOnClickListener {
            if (activity is MainActivity){
                (activity as MainActivity).showMainActToastMessage()
            }
            dismiss()
        }
    }
}