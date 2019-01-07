package com.example.molys.cartapplication.recyclerview.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.molys.cartapplication.R
import com.example.molys.cartapplication.recyclerview.items.HandingItem
import com.example.molys.cartapplication.recyclerview.items.TitleItem

class TitleHolder(view:View) : RecyclerView.ViewHolder(view) {
    val tvTitle : TextView = view.findViewById(R.id.tv_title)

    fun onBind(title : TitleItem){
        tvTitle.text = title.title
    }
}