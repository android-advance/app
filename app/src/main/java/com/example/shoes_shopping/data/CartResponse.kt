package com.example.shoes_shopping.data

import com.example.shoes_shopping.model.ItemInCart

data class CartResponse(
    val email:String,
    val items:List<ItemInCart>
)