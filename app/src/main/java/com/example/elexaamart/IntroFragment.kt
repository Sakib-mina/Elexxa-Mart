package com.example.elexaamart


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.elexaamart.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroBinding.inflate(inflater, container, false)
        starter()
        return binding.root
    }

    private fun starter() {

        with(binding) {
            loginBtn.setOnClickListener {
                findNavController().navigate(R.id.action_introFragment_to_loginFragment)
            }
            registerBtn.setOnClickListener {
                findNavController().navigate(R.id.action_introFragment_to_registerFragment)
            }
        }
    }
}

