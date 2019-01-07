package com.example.molys.cartapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.molys.cartapplication.model.Cart
import com.example.molys.cartapplication.recyclerview.adapter.CartAdapter
import com.example.molys.cartapplication.recyclerview.creator.CartCreator
import com.google.gson.Gson
import java.io.IOException
import java.nio.charset.StandardCharsets

class MainActivity : AppCompatActivity() {

    private lateinit var rvCart : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInstances()
    }

    private fun initInstances() {
        rvCart = findViewById(R.id.rv_cart)
        rvCart.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = CartAdapter(CartCreator.toBaseItem(LoadFileJson()!!))
        }
    }

    private fun LoadFileJson(): Cart? {
        try {
            val jsonFile = assets.open("cart.json")
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            val json = String(buffer, StandardCharsets.UTF_8)
            val cart = Gson().fromJson<Cart>(json,Cart::class.java)
            return cart
        }catch (ex : IOException){
            ex.printStackTrace()
        }
        return null
    }

    interface PickerItem{
        fun plus(price: Float)
        fun minus(price: Float)
    }

}
