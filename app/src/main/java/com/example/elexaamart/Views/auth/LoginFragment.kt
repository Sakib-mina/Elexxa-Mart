package com.example.elexaamart.Views.auth

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.elexaamart.Data.models.UserLogin
import com.example.elexaamart.base.BaseFragment
import com.example.elexaamart.core.DataState
import com.example.elexaamart.databinding.FragmentLoginBinding
import com.example.elexaamart.utils.isEmpty
import com.example.elexaamart.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModels()

    override fun setListener() {

        with(binding) {
            loginBtn.setOnClickListener {
                email.isEmpty()
                passwordL.isEmpty()

                if (!email.isEmpty() && !passwordL.isEmpty()) {
                    val user = UserLogin(
                        email.text.toString(),
                        passwordL.text.toString(),
                    )
                    viewModel.userLogin(user)
                }
            }
        }
    }

    override fun allObserver() {
        loginObserver()
    }

    private fun loginObserver() {
        viewModel.loginResponse.observe(viewLifecycleOwner) {

            when (it) {
                is DataState.Error -> {
                    loading.dismiss()
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }

                is DataState.Loading -> {
                    loading.show()
                    Toast.makeText(context, "Loading....", Toast.LENGTH_SHORT).show()
                }

                is DataState.Success -> {
                    loading.dismiss()
                    Toast.makeText(context, "created User: ${it.data}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}