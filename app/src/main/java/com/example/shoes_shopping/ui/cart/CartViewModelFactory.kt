package com.example.shoes_shopping.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoes_shopping.data.CartRepository

class CartViewModelFactory(
    private val cartRepository: CartRepository,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CartViewModel(cartRepository) as T
        }

        throw IllegalArgumentException("Unable construct viewModel")
    }

}