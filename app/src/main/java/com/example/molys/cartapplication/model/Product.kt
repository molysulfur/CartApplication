package com.example.molys.cartapplication.model

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("id") val id : Int,
    @SerializedName("url") val url : String,
    @SerializedName("item_name") val itemName : String,
    @SerializedName("price") val price : Float
)