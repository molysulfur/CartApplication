package com.example.molys.cartapplication.recyclerview.holder

import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.molys.cartapplication.MainActivity
import com.example.molys.cartapplication.R
import com.example.molys.cartapplication.recyclerview.items.CartItem
import com.example.molys.cartapplication.recyclerview.items.CartSubTotal

class CartItemHolder(val view : View) : RecyclerView.ViewHolder(view){

    val imgItem : ImageView = view.findViewById(R.id.img_item)
    val tvItemName : TextView = view.findViewById(R.id.tv_item_name)
    val tvPrice : TextView = view.findViewById(R.id.tv_price)
    val etItemNumber : EditText = view.findViewById(R.id.et_item_number)
    val btnPlus : Button = view.findViewById(R.id.btn_plus)
    val btnMinus : Button = view.findViewById(R.id.btn_minus)
    lateinit var pickerItem : MainActivity.PickerItem

    fun onBind(cart : CartItem){
        Glide.with(view).load(cart.url).into(imgItem)
        tvItemName.text = cart.itemName
        tvPrice.text = "$${cart.price}"
        etItemNumber.setText(cart.number.toString())
        etItemNumber.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                cart.number = s.toString().toInt()
                CartSubTotal().cartTotalPrice = cart.number * cart.price
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        btnPlus.setOnClickListener {
            cart.number++
            etItemNumber.setText(cart.number.toString())
            pickerItem.plus(cart.price)
        }

        btnMinus.setOnClickListener {
            cart.number--
            etItemNumber.setText(cart.number.toString())
            pickerItem.minus(cart.price)
        }
    }

    fun onPickerItem(pickerItem: MainActivity.PickerItem){
        this.pickerItem = pickerItem
    }

}