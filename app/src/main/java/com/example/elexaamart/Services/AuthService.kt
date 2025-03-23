package com.example.elexaamart.Services

import com.example.elexaamart.Data.models.UserLogin
import com.example.elexaamart.Data.models.UserRegister
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface AuthService {

    fun userRegistration(user: UserRegister) : Task<AuthResult>
    fun userLogin(user: UserLogin) : Task<AuthResult>

}