package com.example.molys.cartapplication.recyclerview.creator

import android.util.Log
import com.example.molys.cartapplication.model.Cart
import com.example.molys.cartapplication.recyclerview.items.*

class CartCreator{
    companion object {
        const val TYPE_TITLE = 0
        const val TYPE_CART = 1
        const val TYPE_SUBTOTAL_ITEM = 2
        const val TYPE_HANDING = 3
        const val TYPE_TOTAL_PRICE = 4

        fun toBaseItem(cart: Cart) : List<BaseItem>{

            val listItem = ArrayList<BaseItem>()
            val cartSubTotal = CartSubTotal.getInstance()!! as CartSubTotal
            listItem.add(TitleItem())
            for (cartNumber in 0 until cart.cart.size){
                val cartItem = CartItem(cart.cart[cartNumber])
                listItem.add(cartItem)
                cartSubTotal.cartTotalPrice += (cartItem.price * cartItem.number)
            }
            listItem.add(SubTotalItem())
            listItem.add(HandingItem())
            listItem.add(cartSubTotal)
            return listItem
        }
    }
}