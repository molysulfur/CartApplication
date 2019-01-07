package com.example.molys.cartapplication.recyclerview.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.molys.cartapplication.R
import com.example.molys.cartapplication.recyclerview.items.HandingItem
import com.example.molys.cartapplication.recyclerview.items.SubTotalItem

class SubTotalHolder(val view : View) : RecyclerView.ViewHolder(view){
    val tvSubtotalNumber : TextView = view.findViewById(R.id.tv_subtotal_number)
    val tvSubtotalPrice : TextView = view.findViewById(R.id.tv_subtotal_price)

    fun onBindCartSubtotal(subtotal : SubTotalItem){
        tvSubtotalNumber.text = "Cart Subtotal {${subtotal.subtotal} items}"
        tvSubtotalPrice.text = "$${subtotal.subtotalPrice}"
    }

    fun onBindHanding(handing : HandingItem){
        tvSubtotalNumber.text = "Shopping and handing"
        tvSubtotalPrice.text = "$${handing.handing}"
    }
}