package com.sopt_nyh.retrofit2_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.sopt_nyh.retrofit2_example.db.SharedPreferenceController
import com.sopt_nyh.retrofit2_example.get.GetDetailedBoardResponse
import com.sopt_nyh.retrofit2_example.network.ApplicationController
import com.sopt_nyh.retrofit2_example.network.NetworkService
import kotlinx.android.synthetic.main.activity_detailed_board.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailedBoardActivity : AppCompatActivity() {

    val networkService : NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_board)

        val b_id = intent.getIntExtra("b_id", -1)

        getDetailedBoardResponse(b_id)

        setOnBtnClickListener()

    }

    private fun getDetailedBoardResponse(board_id : Int){
        val myToken : String = SharedPreferenceController.getAuthorization(this)
        val getDetaildBoardResponse= networkService.getDetailedBoardResponse("application/json", myToken, board_id)
        getDetaildBoardResponse.enqueue(object : Callback<GetDetailedBoardResponse>{
            override fun onFailure(call: Call<GetDetailedBoardResponse>, t: Throwable) {
                Log.e("detail board fail", t.toString())
            }

            override fun onResponse(call: Call<GetDetailedBoardResponse>, response: Response<GetDetailedBoardResponse>) {
                if (response.isSuccessful){
                    val title : String = response.body()!!.data.b_title
                    val contents : String = response.body()!!.data.b_contents
                    val image : String = response.body()!!.data.b_photo

                    setDetailedBoardView(title, contents, image)
                }
            }
        })

    }

    private fun setDetailedBoardView(title : String?, contents : String?, image : String?){
        title?.let {
            tv_detailed_board_act_title.text = title
        }
        contents?.let {
            tv_detailed_board_act_content.text = contents
        }
        image?.let {
            Glide.with(this).load(image).into(iv_detailed_board_act_image)
        }
    }

    private fun setOnBtnClickListener(){
        btn_detailed_board_act_back.setOnClickListener {
            finish()
        }
    }



}
