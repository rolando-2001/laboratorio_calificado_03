package com.rolando.casapaico.poketinder

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.rolando.casapaico.poketinder.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var  registerViewModel : RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerViewModel= RegisterViewModel(this)
        observaValues()
    }



    fun observaValues(){

        registerViewModel.inputsError.observe(this){
            Toast.makeText(this, "Los campos de correo electrónico y contraseña " +
                    "no pueden estar vacíos,email tiene que ser valido", Toast.LENGTH_SHORT).show()
        }

        registerViewModel.registerSuccess.observe(this){
            startActivity(Intent(this, LoginActivity::class.java))
        }


        binding.btnRegister.setOnClickListener{

           val edtPassword =binding.edtPassword.text.toString()
           val edtPassword2 = binding.edtPassword2.text.toString()
           val edtEmail = binding.edtEmail.text.toString()



           if (edtPassword != edtPassword2) {
               showToast("Las contraseñas no coinciden")
           }else{
               registerViewModel.validateInputs(edtEmail, edtPassword)
           }


        }


        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.btnBackCloseLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }



    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }



}