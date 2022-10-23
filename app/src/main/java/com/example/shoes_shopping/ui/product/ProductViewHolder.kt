package com.example.shoes_shopping.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes_shopping.R
import com.example.shoes_shopping.databinding.ItemProductBinding
import com.example.shoes_shopping.model.Product
import com.example.shoes_shopping.utils.ImageRequester

class ProductViewHolder(
    private val binding: ItemProductBinding,
    private val openProductDetail: (Product) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {
    private var product: Product? = null

    init {
        binding.layoutItemProduct.setOnClickListener {
            product?.let {
                openProductDetail(it)
            }
        }
    }

    fun onBind(product: Product) {
        this.product = product
        ImageRequester.setImageFromUrl(binding.productImage,product.url)
        binding.txtProductTitle.text = product.title
        binding.txtProductPrice.text = ("$${product.price}")

    }

    companion object {
        fun create(
            inflater: LayoutInflater,
            parent: ViewGroup,
            openProductDetail: (Product) -> Unit
        ): ProductViewHolder {
            val binding: ItemProductBinding =
                DataBindingUtil.inflate(inflater, R.layout.item_product, parent, false)
            return ProductViewHolder(binding, openProductDetail)
        }
    }
}