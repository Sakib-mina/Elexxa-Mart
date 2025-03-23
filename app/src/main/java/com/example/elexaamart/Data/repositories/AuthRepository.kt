package com.example.elexaamart.Data.repositories

import com.example.elexaamart.Data.models.UserLogin
import com.example.elexaamart.Data.models.UserRegister
import com.example.elexaamart.Services.AuthService
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRepository @Inject constructor(private val auth: FirebaseAuth) : AuthService {

    override fun userRegistration(user: UserRegister): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(user.email, user.password)
    }

    override fun userLogin(user: UserLogin): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(user.email, user.password)
    }
}