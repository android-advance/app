package com.example.shoes_shopping.ui.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.shoes_shopping.R
import com.example.shoes_shopping.data.SettingRepository
import com.example.shoes_shopping.model.UserModel
import com.example.shoes_shopping.utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import java.io.IOException


class SettingViewModel(
private val settingRepository: SettingRepository,
private val context: Context
) : ViewModel() {

    fun updateUser(user: UserModel) = liveData(Dispatchers.IO) {
        emit(Resource.Loading(null))
        try {
            emit(Resource.Success(settingRepository.updateProfile(user)))
        } catch (ex: IOException) {
            emit(Resource.Error(null, context.resources.getString(R.string.connect_failed)))
        } catch (ex: HttpException) {
            emit(Resource.Error(null, context.resources.getString(R.string.update_profile_failed)))
        }
    }

}