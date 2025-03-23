package com.example.elexaamart.Views.starter

import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController
import com.example.elexaamart.R
import com.example.elexaamart.base.BaseFragment
import com.example.elexaamart.databinding.FragmentIntroBinding

@AndroidEntryPoint
class IntroFragment : BaseFragment<FragmentIntroBinding>(FragmentIntroBinding::inflate) {

    override fun setListener() {

        with(binding){

            loginBtn.setOnClickListener {

                findNavController().navigate(R.id.action_introFragment_to_loginFragment)

            }
            registerBtn.setOnClickListener {

                findNavController().navigate(R.id.action_introFragment_to_registerFragment)

            }
        }
    }

    override fun allObserver() {

    }

}

