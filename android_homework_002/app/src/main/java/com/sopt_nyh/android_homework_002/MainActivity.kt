package com.sopt_nyh.android_homework_002

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    //startActivityForResult로 시작시킬 Activity 구분을 위한 상수 코드
    private val REQUEST_CODE_SIGN_IN = 1004

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnBtnClickListener()
    }

    //버튼 리스너를 모아둔 함수
    private fun setOnBtnClickListener() {
        btn_main_act_sign_in.setOnClickListener {
            toast("로그인")
        }


        btn_main_act_sign_up.setOnClickListener {
            val mInputId: String = et_main_act_id.text.toString()

            //anko version
            startActivityForResult<SignUpActivity>(REQUEST_CODE_SIGN_IN, "id" to mInputId)


            //original version
//            val intent: Intent = Intent(this, SignUpActivity::class.java)
//            intent.putExtra("id", mInputId)
//            startActivityForResult(intent, REQUEST_CODE_SIGN_IN)
        }
    }

    //결과를 받는 콜백 함수. Main Activity에서 호출한 다른 Activity가 신호를 보내면 결과를 받음.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //첫번째로 어떤 Activity의 신호인지 체크
        if (requestCode == REQUEST_CODE_SIGN_IN) {
            //그 Activity에서
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    val id = data.getStringExtra("id")
                    et_main_act_id.setText(id)
                }

//                data?.let {
//                    val id = data.getStringExtra("id")
//                    et_main_act_id.setText(id)
//                }
            }
        }
    }
}
