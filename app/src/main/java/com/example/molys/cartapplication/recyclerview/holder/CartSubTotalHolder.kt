package com.example.molys.cartapplication.recyclerview.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.molys.cartapplication.R
import com.example.molys.cartapplication.recyclerview.items.CartSubTotal

class CartSubTotalHolder(val view : View) : RecyclerView.ViewHolder(view){
    val tvCartSubtotal : TextView = view.findViewById(R.id.tv_cart_subtotal)
    val tvCartTotalPrice : TextView = view.findViewById(R.id.tv_carttotal_price)

    fun onBind(carttotal : CartSubTotal){
        tvCartSubtotal.text = "Cart Subtotal"
        tvCartTotalPrice.text = "$${carttotal.cartTotalPrice}"
    }
}