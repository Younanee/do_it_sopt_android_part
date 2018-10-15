package com.sopt_nyh.android_homework_002

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setInitText()
        setOnBtnClickListener()
    }

    private fun setInitText() {
        //타입 옆 ?가 붙은 것은 null 일 수 도 있다는 null 허용 표시, 추후 처리해주어야 한다! 보충 세미나를 통해 더 알려드리겠습니다.
        val id: String? = intent.getStringExtra("id")
        if (id != null) {
            et_sign_up_act_id.setText(id)
        }

//        intent.getStringExtra("id")?.let {
//            val initId = it
//            et_sign_up_act_id.setText(initId)
//        }
    }

    private fun setOnBtnClickListener() {
        btn_sign_up_act_close.setOnClickListener {
            finish()
        }
        btn_sign_up_act_complete.setOnClickListener {
            val intent: Intent = Intent()
            intent.putExtra("id", et_sign_up_act_id.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
