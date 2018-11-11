package com.sopt_nyh.sub_seminar002_example.fragment

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt_nyh.sub_seminar002_example.R
import com.sopt_nyh.sub_seminar002_example.activity.MemoActivity
import com.sopt_nyh.sub_seminar002_example.db.SharedPreferenceController
import kotlinx.android.synthetic.main.dialog_fragment_sign_up.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class SignUpDialogFragment : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view : View = inflater.inflate(R.layout.dialog_fragment_sign_up, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setOnBtnClickListener()
    }
    private fun setOnBtnClickListener(){
        btn_sign_up_complete.setOnClickListener {
            SharedPreferenceController.clearUserSharedPreferences(activity!!)

            val id : String = et_sign_up_frag_id.text.toString()
            val pw : String = et_sign_up_frag_pw.text.toString()

            SharedPreferenceController.setUserID(activity!!, id)
            SharedPreferenceController.setUserPW(activity!!, pw)

            dismiss()
        }
        btn_sign_up_close.setOnClickListener {
            dismiss()
        }
    }
}