package com.example.shoes_shopping.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoes_shopping.model.ItemInCart

class CartAdapter(
    private val onItemClick: (ItemInCart) -> Unit,
    private val onItemLongClick: (ItemInCart) -> Boolean,
    private val updateAmount: (ItemInCart, ()->Unit) -> Unit
) : RecyclerView.Adapter<CartViewHolder>() {
    var cart: List<ItemInCart> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CartViewHolder.create(inflater, parent, onItemClick, onItemLongClick, updateAmount)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.onBind(cart[position])
    }

    override fun getItemCount(): Int = cart.size
}