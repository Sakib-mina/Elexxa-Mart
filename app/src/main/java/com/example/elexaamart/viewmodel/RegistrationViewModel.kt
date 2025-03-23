package com.example.elexaamart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elexaamart.Data.models.UserRegister
import com.example.elexaamart.Data.repositories.AuthRepository
import com.example.elexaamart.core.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val authService: AuthRepository) : ViewModel() {

    private val _registrationResponse = MutableLiveData<DataState<UserRegister>>()

    val registrationResponse:LiveData<DataState<UserRegister>> = _registrationResponse

    fun userRegistration(user: UserRegister){
        _registrationResponse.postValue(DataState.Loading())

        authService.userRegistration(user)
            .addOnSuccessListener {
                _registrationResponse.postValue(DataState.Success(user))

            }.addOnFailureListener {error->
                _registrationResponse.postValue(DataState.Error("${error.message}"))
            }

    }
}