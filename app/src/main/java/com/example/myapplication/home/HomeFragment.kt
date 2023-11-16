package com.example.myapplication.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private var _binding:FragmentHomeBinding?=null
    private val binding : FragmentHomeBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        bindViews()
        return binding.root
    }
    private fun bindViews(){

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}