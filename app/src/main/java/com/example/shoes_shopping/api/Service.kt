package com.example.shoes_shopping.api

import com.example.shoes_shopping.data.CartRequest
import com.example.shoes_shopping.data.CartResponse
import com.example.shoes_shopping.model.Product
import com.example.shoes_shopping.model.UserModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface Service {
    @POST("authentication/signup")
    suspend fun signUp(@Body user: UserModel)

    @POST("authentication/signin")
    suspend fun signIn(@Body user: UserModel): UserModel

    @GET("products")
    suspend fun getAllProduct(): List<Product>

    @PUT("authentication/profile")
    suspend fun updateProfile(@Body user: UserModel): UserModel

    @POST("cart")
    suspend fun addProductToCart(@Body request: CartRequest)

    @GET("cart/{email}")
    suspend fun getCart(
        @Path("email") email: String
    ): CartResponse

    @PATCH("cart")
    suspend fun updateItemAmount(@Body request: CartRequest)

    @PUT("cart")
    suspend fun deleteItem(@Body request: CartRequest)

    companion object {
        private const val BASE_URL = "http://192.168.43.30:8080/"

        fun create(): Service = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(OkHttpClientConfig.getOkHttpClient()).build()
            .create(Service::class.java)


    }

}