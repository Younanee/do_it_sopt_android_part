package com.sopt_nyh.sub_seminar002_example

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.sopt_nyh.sub_seminar002_example.data.MyItemData
import org.jetbrains.anko.toast

class MyItemRecyclerViewAdapter(val ctx : Context, val dataList : ArrayList<MyItemData>) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_my_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.counter.text = dataList[position].counter.toString()
        if (!dataList[position].islike){
            holder.like_img.visibility = View.GONE
        }

        holder.btn.setOnClickListener {
            ctx.toast("${dataList[position].counter}")
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val counter : TextView = itemView.findViewById(R.id.tv_rv_item_my_item_counter) as TextView
        val like_img : ImageView = itemView.findViewById(R.id.iv_rv_item_my_item_like_img) as ImageView
        val btn : RelativeLayout = itemView.findViewById(R.id.btn_rv_item_my_item_background) as RelativeLayout
    }
}