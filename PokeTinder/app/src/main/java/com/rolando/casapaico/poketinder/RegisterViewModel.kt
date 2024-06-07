package com.rolando.casapaico.poketinder

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegisterViewModel(
    context: Context
): ViewModel(){

    val inputsError= MutableLiveData<Boolean>()
    val registerSuccess = MutableLiveData<Boolean>()
    val saveCredentialsError= MutableLiveData<Boolean>()

    private  var  sharedPreferencesRepository : SharedPreferencesRepository =
        SharedPreferencesRepository().also {
            it.setSharedPreferences(context)
    }

    fun validateInputs(email:String, password:String) {
        if (isEmtyInputs(email, password) || !validateEmial(email)){
            inputsError.postValue(true)
            return
        }
        saveUserCredentials(email, password)

    }


    fun isEmtyInputs(email:String, password:String)=email.isEmpty() || password.isEmpty()

    private fun saveUserCredentials(email: String, password: String) {
        val emailSaved =sharedPreferencesRepository.saveUserEmail(email)
        val passwordSave =sharedPreferencesRepository.saveUserPassword(password)

        if (emailSaved && passwordSave){
            registerSuccess.postValue(true)
        }else{
            saveCredentialsError .postValue(true)
        }

    }

    fun validateEmial(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }



}