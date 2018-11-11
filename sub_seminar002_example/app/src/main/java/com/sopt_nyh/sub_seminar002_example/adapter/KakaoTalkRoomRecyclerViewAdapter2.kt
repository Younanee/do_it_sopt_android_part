package com.sopt_nyh.sub_seminar002_example.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sopt_nyh.sub_seminar002_example.KakaoTalkRoomData
import com.sopt_nyh.sub_seminar002_example.R

class KakaoTalkRoomRecyclerViewAdapter2(val ctx : Context, var dataList : ArrayList<KakaoTalkRoomData>)
    : RecyclerView.Adapter<KakaoTalkRoomRecyclerViewAdapter2.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view : View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_kakao_talk_room, parent)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.mTitle.text = dataList[position].title
        holder.mContent.text = dataList[position].content
        holder.person_cnt.text = dataList[position].person_cnt.toString()
        holder.mTime.text = dataList[position].time
    }


    inner class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val mTitle : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_title) as TextView
        val mContent : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_content) as TextView
        val person_cnt : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_person_cnt) as TextView
        val mTime : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_time) as TextView
    }
}