package com.rolando.casapaico.poketinder

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rolando.casapaico.poketinder.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private  lateinit  var loginViewModel  : LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loginViewModel= LoginViewModel(this)
        observeValues()
    }

  private  fun observeValues(){
        loginViewModel.inputsError.observe(this){
            Toast.makeText(this, "Ingrese los  datos  completos", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.authError.observe(this){
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }

        loginViewModel.loginSuccess.observe(this){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


        binding.btnLogin.setOnClickListener {
            loginViewModel.validateInputs(
                binding.edtEmail.text.toString(),
                binding.edtPassword.text.toString()
            )

        }

        binding.btnRegister.setOnClickListener{
            startActivity(Intent(this, RegisterActivity::class.java))
        }

      binding.btnBackCloseRegister.setOnClickListener{
          startActivity(Intent(this, RegisterActivity::class.java))
      }

    }





}