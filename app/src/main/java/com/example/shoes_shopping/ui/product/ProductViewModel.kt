package com.example.shoes_shopping.ui.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.shoes_shopping.data.ProductRepository
import com.example.shoes_shopping.utils.Resource
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException
import java.io.IOException

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    fun getAllProduct() = liveData(Dispatchers.IO) {
        emit(Resource.Loading(null))
        try {
            emit(Resource.Success(productRepository.getAllProduct()))
        } catch (ex: IOException) {
            emit(Resource.Error(null, ex.message ?: "Error"))
        } catch (ex: HttpException) {
            emit(Resource.Error(null, ex.message ?: "Error"))
        }
    }
}