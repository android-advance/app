package com.example.shoes_shopping.data

import com.example.shoes_shopping.api.Service
import com.example.shoes_shopping.model.UserModel

class SettingRepository(private val service: Service) {

    suspend fun updateProfile(user: UserModel) = service.updateProfile(user)

}