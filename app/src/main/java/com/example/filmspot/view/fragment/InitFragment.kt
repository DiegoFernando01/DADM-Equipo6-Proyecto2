package com.example.filmspot.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController
import com.example.filmspot.R
import com.bumptech.glide.Glide
import com.example.filmspot.databinding.FragmentInitBinding
import com.example.filmspot.databinding.FragmentStartBinding

class InitFragment : Fragment() {

    private var _binding: FragmentInitBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView( // Operaciones sobre la vista durante su creación
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated( // Operaciones sobre la vista después su creación
        view: View,
        savedInstanceState: Bundle?

    ) {
        Glide.with(this)
            .load("https://pymstatic.com/107354/conversions/sindrome-truman-social.jpg")
            .into(binding.ivMovieImage)
        super.onViewCreated(view, savedInstanceState)
        controllers()
    }

    private fun controllers() {
        binding.btSignup.setOnClickListener() {
            findNavController().navigate(R.id.action_InitFragment_to_SignUpFragment)
        }
        binding.btSignin.setOnClickListener() {
            findNavController().navigate(R.id.action_InitFragment_to_SignInFragment)
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_InitFragment_to_StartFramgment)
                }
            }
        )
    }

}