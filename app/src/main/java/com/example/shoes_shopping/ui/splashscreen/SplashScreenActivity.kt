package com.example.shoes_shopping.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat.startActivity
import com.example.shoes_shopping.R
import com.example.shoes_shopping.base.BaseActivity
import com.example.shoes_shopping.databinding.ActivitySplashScreenBinding
import com.example.shoes_shopping.ui.authentication.login.LoginActivity

class SplashScreenActivity : BaseActivity() {

    private val binding: ActivitySplashScreenBinding
        get() = (getViewBinding() as ActivitySplashScreenBinding)

    override fun getLayoutId(): Int = R.layout.activity_splash_screen

    override fun initControls(savedInstanceState: Bundle?) {

        val logoAnimation = AnimationUtils.loadAnimation(this,R.anim.logo_animation)
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_animation)
        binding.appLogo.startAnimation(logoAnimation)
        binding.appText.startAnimation(textAnimation)

        val intent = Intent(this, LoginActivity::class.java)
        val thread: Thread = object : Thread() {
            override fun run() {
                super.run()
                try {
                    sleep(3000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(intent)
                    finish()
                }
            }
        }
        thread.start()
    }

    override fun initEvents() {

    }

}