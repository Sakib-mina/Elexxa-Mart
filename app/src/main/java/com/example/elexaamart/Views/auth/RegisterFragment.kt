package com.example.elexaamart.Views.auth

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.elexaamart.Data.models.UserRegister
import com.example.elexaamart.base.BaseFragment
import com.example.elexaamart.core.DataState
import com.example.elexaamart.databinding.FragmentRegisterBinding
import com.example.elexaamart.utils.isEmpty
import com.example.elexaamart.viewmodel.RegistrationViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels()

    override fun setListener() {

        with(binding) {

            registerBtn.setOnClickListener {
                nameEt.isEmpty()
                emailEt.isEmpty()
                passwordEt.isEmpty()

                if (!nameEt.isEmpty() && !emailEt.isEmpty() && !passwordEt.isEmpty()) {

                    val user = UserRegister(
                        nameEt.text.toString(),
                        emailEt.text.toString(),
                        passwordEt.text.toString(),
                        "Seller",
                        ""
                    )
                    viewModel.userRegistration(user)
                }
            }
        }
    }

    override fun allObserver() {
        registrationObserver()
    }

    private fun registrationObserver() {
        viewModel.registrationResponse.observe(viewLifecycleOwner) {

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