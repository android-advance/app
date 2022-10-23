package com.example.shoes_shopping.data

import com.example.shoes_shopping.api.Service

class CartRepository(private val service: Service) {

    suspend fun addProductToCart(request: CartRequest) = service.addProductToCart(request)

    suspend fun getCart() = service.getCart(User.email)

    suspend fun updateItemAmount(request: CartRequest) = service.updateItemAmount(request)

    suspend fun deleteItem(request: CartRequest) = service.deleteItem(request)
}