package com.example.molys.cartapplication.recyclerview.items

import com.example.molys.cartapplication.recyclerview.creator.CartCreator

class CartSubTotal : BaseItem(CartCreator.TYPE_TOTAL_PRICE){
    var cartTotalPrice = 0F

    companion object {
        var cartSubTotal : CartSubTotal? = null

        fun getInstance(): BaseItem? {
            if(cartSubTotal == null){
                cartSubTotal = CartSubTotal()
                return cartSubTotal
            }else{
                return cartSubTotal
            }
        }
    }
}