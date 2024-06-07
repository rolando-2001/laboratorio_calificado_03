package com.rolando.casapaico.poketinder

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rolando.casapaico.poketinder.databinding.ActivitySplashBinding
import com.rommansabbir.animationx.Attention
import com.rommansabbir.animationx.animationXAttention

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imvLogo.animationXAttention(Attention.ATTENTION_SHAKE)
        runPostDelayed()
    }
    private fun runPostDelayed() {
        Handler(Looper.getMainLooper()).postDelayed({
            goMainActivity()
        }, 3000)
    }


    private fun goMainActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}