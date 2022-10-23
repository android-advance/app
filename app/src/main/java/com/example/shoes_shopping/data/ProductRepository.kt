package com.example.shoes_shopping.data

import com.example.shoes_shopping.api.Service

class ProductRepository(private val service: Service) {

    suspend fun getAllProduct() = service.getAllProduct()
}