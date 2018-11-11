package com.sopt_nyh.sub_seminar002_example

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.sopt_nyh.sub_seminar002_example.data.MyItemData
import kotlinx.android.synthetic.main.activity_grid_list.*

class GridListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_list)
        val dataList : ArrayList<MyItemData> = ArrayList()

        for (i in 1..20){
            if (i%2 == 0){
                dataList.add(MyItemData(i, true))
            } else {
                dataList.add(MyItemData(i, false))
            }
        }

        rv_grid_list_act_list.adapter = MyItemRecyclerViewAdapter(this, dataList)
        rv_grid_list_act_list.layoutManager = GridLayoutManager(this, 3)

    }
}
