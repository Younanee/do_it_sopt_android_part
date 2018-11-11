package com.sopt_nyh.sub_seminar002_example.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.sopt_nyh.sub_seminar002_example.R
import com.sopt_nyh.sub_seminar002_example.adapter.MemoRecyclerViewAdapter
import com.sopt_nyh.sub_seminar002_example.data.MemoData
import com.sopt_nyh.sub_seminar002_example.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_memo.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MemoActivity : AppCompatActivity() {

    lateinit var recycMemoRecyclerViewAdapter: MemoRecyclerViewAdapter

    val dataList: ArrayList<MemoData> by lazy {
        ArrayList<MemoData>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        setRecyclerView()
        setOnClickListener()

        refresh_memo_act.setOnRefreshListener {
            toast("새로 고침!")
            //이곳에 서버 통신과 같은 로직을 구현해주시면 됩니다!!
            refresh_memo_act.isRefreshing = false // 뺑뺑이 멈추기!
        }
    }


    private fun setRecyclerView() {
        recycMemoRecyclerViewAdapter = MemoRecyclerViewAdapter(this, dataList)
        rv_memo_act_memo_list.adapter = recycMemoRecyclerViewAdapter
        rv_memo_act_memo_list.layoutManager = LinearLayoutManager(this)
    }

    private fun addItem(){
        if (et_memo_act_title.text.toString().isNotEmpty() && et_memo_act_content.text.toString().isNotEmpty()){
            val position = recycMemoRecyclerViewAdapter.itemCount
            //recycMemoRecyclerViewAdapter.dataList.add(MemoData(et_memo_act_title.text.toString(), et_memo_act_content.text.toString()))
            //recycMemoRecyclerViewAdapter.notifyDataSetChanged()
            //recycMemoRecyclerViewAdapter.notifyItemInserted(position)
            recycMemoRecyclerViewAdapter.addNewItem(MemoData(et_memo_act_title.text.toString(), et_memo_act_content.text.toString()))
        }
    }

    private fun setOnClickListener() {
        btn_memo_act_add_memo.setOnClickListener {
            addItem()
        }
        btn_memo_act_logout.setOnClickListener {
            SharedPreferenceController.clearUserSharedPreferences(this)
            startActivity<LoginActivity>()
            finish()
        }
    }


}
