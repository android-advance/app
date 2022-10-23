package com.example.shoes_shopping.data

import com.example.shoes_shopping.api.Service
import com.example.shoes_shopping.model.UserModel

class AuthenticationRepository(private val service: Service) {
    suspend fun signUp(user: UserModel) = service.signUp(user)

    suspend fun signIn(user: UserModel) = service.signIn(user)
}