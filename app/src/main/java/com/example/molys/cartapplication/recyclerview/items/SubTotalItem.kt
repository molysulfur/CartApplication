package com.example.molys.cartapplication.recyclerview.items

import com.example.molys.cartapplication.recyclerview.creator.CartCreator

class SubTotalItem : BaseItem(CartCreator.TYPE_SUBTOTAL_ITEM) {
    var subtotal = 0
    var subtotalPrice = 0
}