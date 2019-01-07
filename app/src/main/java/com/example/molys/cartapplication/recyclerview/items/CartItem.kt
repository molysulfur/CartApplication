package com.example.molys.cartapplication.recyclerview.items

import com.example.molys.cartapplication.model.Product
import com.example.molys.cartapplication.recyclerview.creator.CartCreator

class CartItem(product: Product) : BaseItem(CartCreator.TYPE_CART) {
    var id = product.id
    var url : String = product.url
    var itemName : String = product.itemName
    var price : Float = product.price
    var number = 1
}