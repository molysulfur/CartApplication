package com.example.molys.cartapplication.model

import com.google.gson.annotations.SerializedName

data class Cart(
    @SerializedName("Cart") val cart : ArrayList<Product>
)