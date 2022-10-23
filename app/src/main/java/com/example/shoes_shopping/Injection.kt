package com.example.shoes_shopping

import android.content.Context
import com.example.shoes_shopping.api.Service
import com.example.shoes_shopping.data.AuthenticationRepository
import com.example.shoes_shopping.data.CartRepository
import com.example.shoes_shopping.data.ProductRepository
import com.example.shoes_shopping.data.SettingRepository
import com.example.shoes_shopping.ui.authentication.AuthenticationViewModelFactory
import com.example.shoes_shopping.ui.cart.CartViewModelFactory
import com.example.shoes_shopping.ui.product.ProductViewModelFactory
import com.example.shoes_shopping.ui.settings.SettingViewModelFactory

object Injection {
    private fun provideAuthenticationRepo() =
        AuthenticationRepository(Service.create())

    private fun provideProductRepository() =
        ProductRepository(Service.create())

    private fun provideCartRepository() =
        CartRepository(Service.create())

    private fun provideSettingRepository() =
        SettingRepository(Service.create())


    fun provideAuthenViewModelFactory(context: Context) = AuthenticationViewModelFactory(
        provideAuthenticationRepo(), context
    )

    fun provideProductViewModelFactory() = ProductViewModelFactory(
        provideProductRepository()
    )

    fun provideCartViewModelFactory() = CartViewModelFactory(
        provideCartRepository()
    )
    fun provideSettingViewModelFactory(context: Context) = SettingViewModelFactory(
        provideSettingRepository(), context
    )
}