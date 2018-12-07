package com.sopt_nyh.retrofit2_example.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sopt_nyh.retrofit2_example.DetailedBoardActivity
import com.sopt_nyh.retrofit2_example.R
import com.sopt_nyh.retrofit2_example.data.BoardData
import kotlinx.android.synthetic.main.rv_item_board.view.*
import org.jetbrains.anko.startActivity

class BoardRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<BoardData>) : RecyclerView.Adapter<BoardRecyclerViewAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(ctx).inflate(R.layout.rv_item_board, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].b_title
        holder.like_cnt.text = dataList[position].b_like.toString()
        holder.date.text = dataList[position].b_date

        val requestOptions = RequestOptions()
//        requestOptions.placeholder(R.drawable.기본적으로 띄울 이미지)
//        requestOptions.error(R.drawable.에러시 띄울 이미지)
//        requestOptions.override(150)
        Glide.with(ctx)
                .setDefaultRequestOptions(requestOptions)
                .load(dataList[position].b_photo)
                .thumbnail(0.5f)
                .into(holder.image)

        holder.btn_show_detailed.setOnClickListener {
            ctx.startActivity<DetailedBoardActivity>("b_id" to dataList[position].b_id)
        }

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.tv_rv_item_board_title) as TextView
        val like_cnt: TextView = itemView.findViewById(R.id.tv_rv_item_board_like_cnt) as TextView
        val date: TextView = itemView.findViewById(R.id.tv_rv_item_board_date) as TextView
        val image: ImageView = itemView.findViewById(R.id.iv_rv_item_board_image) as ImageView
        val btn_show_detailed : RelativeLayout = itemView.findViewById(R.id.btn_rv_item_board_show_detailed) as RelativeLayout
    }
}