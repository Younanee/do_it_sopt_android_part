package com.sopt_nyh.expandablelistview_exp

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TestDialogFragment() : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //내가만든 layout을 단다. 그냥 프래그먼트 사용하는거랑 똑같음.
        val view : View = inflater.inflate(R.layout.dialog_test, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //여기서 로직짠거 넣으면됨. 역시 프래그먼트랑 또~~똑같다 쉽다.
    }
}