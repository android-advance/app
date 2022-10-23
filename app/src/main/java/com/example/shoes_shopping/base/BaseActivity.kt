package com.example.shoes_shopping.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.databinding.DataBindingUtil

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        initControls(savedInstanceState)
        initEvents()
    }

    abstract fun getLayoutId(): Int

    abstract fun initControls(savedInstanceState: Bundle?)

    abstract fun initEvents()

    fun getViewBinding(): ViewDataBinding {
        return binding
    }

}