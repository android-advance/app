package com.example.shoes_shopping.ui.detail

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoes_shopping.Injection
import com.example.shoes_shopping.R
import com.example.shoes_shopping.base.BaseFragment
import com.example.shoes_shopping.data.CartRequest
import com.example.shoes_shopping.data.User
import com.example.shoes_shopping.databinding.FragmentProductDetailBinding
import com.example.shoes_shopping.model.ItemInCart
import com.example.shoes_shopping.model.Product
import com.example.shoes_shopping.ui.cart.CartViewModel
import com.example.shoes_shopping.utils.ImageRequester
import com.example.shoes_shopping.utils.Resource

class ProductDetailFragment: BaseFragment() {

    private val binding: FragmentProductDetailBinding
        get() = (getViewBinding() as FragmentProductDetailBinding)


    override fun getLayoutId(): Int = R.layout.fragment_product_detail

    var productAmount: Int = 1
        set(value) {
            field = value
            binding.txtProductAmount.text = productAmount.toString()
        }

    private val cartViewModel by lazy {
        ViewModelProvider(
            this,
            Injection.provideCartViewModelFactory()
        )[CartViewModel::class.java]
    }
    private var product: Product? = null

    private val dialogLoading by lazy {
        Dialog(requireContext())
    }


    override fun initControls(view: View, savedInstanceState: Bundle?) {
        dialogLoading.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogLoading.setCancelable(false)
        dialogLoading.setContentView(R.layout.dialog_loading)
        val product = arguments?.get("PRODUCT_DETAIL") as Product?
        this.product = product
        setData()

    }
    private val controller by lazy {
        findNavController()
    }

    override fun initEvents() {
        binding.btnIncrease.setOnClickListener {
            productAmount++
        }

        binding.btnReduce.setOnClickListener {
            productAmount = if (productAmount > 1) productAmount - 1 else productAmount
        }

        binding.btnAddToCart.setOnClickListener {
            product?.let {
                val itemInCart =
                    ItemInCart(it.id, it.title, it.url, it.price, it.description, productAmount)
                val request = CartRequest(User.email, itemInCart)
                cartViewModel.addProductToCart(request).observe(viewLifecycleOwner, {
                    when (it) {
                        is Resource.Success -> {
                            dialogLoading.dismiss()
                            Toast.makeText(requireContext(), R.string.success, Toast.LENGTH_SHORT)
                                .show()
                        }
                        is Resource.Error -> {
                            dialogLoading.dismiss()
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT)
                                .show()
                        }
                        is Resource.Loading -> {
                            dialogLoading.show()
                        }
                    }
                })
                findNavController().popBackStack()
            }
        }

        binding.toolbarDetail.setNavigationOnClickListener {
            controller.popBackStack()
        }
    }

    private fun setData() {
        product?.let {
            ImageRequester.setImageFromUrl(binding.imgProduct, it.url)
            binding.txtProductPrice.text = ("$${it.price}")
            binding.txtProductTitle.text = it.title
            binding.txtProductDescription.text = it.description
            binding.txtProductAmount.text = productAmount.toString()

        }
    }
}