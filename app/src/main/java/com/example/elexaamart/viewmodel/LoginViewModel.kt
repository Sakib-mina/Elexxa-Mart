package com.example.elexaamart.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.elexaamart.Data.models.UserLogin
import com.example.elexaamart.Data.repositories.AuthRepository
import com.example.elexaamart.core.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authService: AuthRepository) : ViewModel() {

    private val _loginResponse = MutableLiveData<DataState<UserLogin>>()
    val loginResponse: LiveData<DataState<UserLogin>> = _loginResponse

    fun userLogin(user: UserLogin) {
        _loginResponse.postValue(DataState.Loading())

        authService.userLogin(user)
            .addOnSuccessListener {
                _loginResponse.postValue(DataState.Success(user))

            }.addOnFailureListener { error ->
                _loginResponse.postValue(DataState.Error("${error.message}"))

            }

    }
}