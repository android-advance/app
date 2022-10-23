package com.example.shoes_shopping.data

import com.example.shoes_shopping.model.ItemInCart
import com.google.gson.annotations.SerializedName


data class CartRequest(
    @field:SerializedName("email") val email: String = User.email,
    @field:SerializedName("item") val item: ItemInCart
)