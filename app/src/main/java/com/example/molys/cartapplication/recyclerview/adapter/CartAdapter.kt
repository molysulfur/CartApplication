package com.example.molys.cartapplication.recyclerview.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.molys.cartapplication.MainActivity.PickerItem
import com.example.molys.cartapplication.R
import com.example.molys.cartapplication.recyclerview.creator.CartCreator
import com.example.molys.cartapplication.recyclerview.creator.CartCreator.Companion.TYPE_TOTAL_PRICE
import com.example.molys.cartapplication.recyclerview.holder.CartItemHolder
import com.example.molys.cartapplication.recyclerview.holder.CartSubTotalHolder
import com.example.molys.cartapplication.recyclerview.holder.SubTotalHolder
import com.example.molys.cartapplication.recyclerview.holder.TitleHolder
import com.example.molys.cartapplication.recyclerview.items.*

class CartAdapter(val listItem : List<BaseItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    val pickerItem = object : PickerItem {
        override fun minus(price: Float) {
            listItem.forEach {
                if(it.type == TYPE_TOTAL_PRICE)
                    (it as CartSubTotal).cartTotalPrice -= price
            }
            notifyDataSetChanged()
        }

        override fun plus(price: Float) {
            listItem.forEach {
                if(it.type == TYPE_TOTAL_PRICE)
                    (it as CartSubTotal).cartTotalPrice += price
            }
            notifyDataSetChanged()
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when(viewType){
            CartCreator.TYPE_TITLE -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_title,viewGroup,false)
                return TitleHolder(view)
            }
            CartCreator.TYPE_CART -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_card,viewGroup,false)
                return CartItemHolder(view)
            }
            CartCreator.TYPE_SUBTOTAL_ITEM -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_subtotal,viewGroup,false)
                return SubTotalHolder(view)
            }
            CartCreator.TYPE_HANDING -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_subtotal,viewGroup,false)
                return SubTotalHolder(view)
            }
            CartCreator.TYPE_TOTAL_PRICE -> {
                val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_cart_subtotal,viewGroup,false)
                return CartSubTotalHolder(view)
            }
            else -> return super.createViewHolder(viewGroup,viewType)
        }
    }

    override fun getItemViewType(position: Int): Int = listItem[position].type

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        when{
            getItemViewType(position) == CartCreator.TYPE_TITLE -> {
                val titleHolder = viewHolder as TitleHolder
                titleHolder.onBind(listItem[position] as TitleItem)
            }
            getItemViewType(position) == CartCreator.TYPE_CART -> {
                val cartItemHolder = viewHolder as CartItemHolder
                cartItemHolder.onBind(listItem[position] as CartItem)
                cartItemHolder.onPickerItem(pickerItem)
            }
            getItemViewType(position) == CartCreator.TYPE_SUBTOTAL_ITEM -> {
                val titleHolder = viewHolder as SubTotalHolder
                titleHolder.onBindCartSubtotal(listItem[position] as SubTotalItem)
            }
            getItemViewType(position) == CartCreator.TYPE_HANDING -> {
                val titleHolder = viewHolder as SubTotalHolder
                titleHolder.onBindHanding(listItem[position] as HandingItem)
            }
            getItemViewType(position) == CartCreator.TYPE_TOTAL_PRICE -> {
                val titleHolder = viewHolder as CartSubTotalHolder
                titleHolder.onBind(listItem[position] as CartSubTotal)
            }
        }
    }


}