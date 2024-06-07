package com.rolando.casapaico.poketinder

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(
    val context:Context

): ViewModel(){
    val inputsError= MutableLiveData<Boolean>()
    val authError =MutableLiveData<Boolean>()
    val loginSuccess = MutableLiveData<Boolean>()

    private  var  sharedPreferencesRepository : SharedPreferencesRepository =
        SharedPreferencesRepository().also {
            it.setSharedPreferences(context)
        }
    fun validateInputs(email:String, password:String){
        if(isEmtyInputs(email, password)){
            inputsError.postValue(true)
            return
        }

        val emailSharedPreferences=sharedPreferencesRepository.getUserEmail()
        val passwordSharedPreferences=sharedPreferencesRepository.getUserPassword()

        if (emailSharedPreferences==email && passwordSharedPreferences==password){
            loginSuccess.postValue(true)
        }else{
            authError.postValue(true)
        }

    }

    fun isEmtyInputs(email:String, password:String)=email.isEmpty() || password.isEmpty()

   fun  validateEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}