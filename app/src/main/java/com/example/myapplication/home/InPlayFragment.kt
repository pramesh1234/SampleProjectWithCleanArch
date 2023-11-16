package com.example.myapplication.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.adapter.InPlayPagerAdapter
import com.example.myapplication.databinding.FragmentInPlayBinding
import com.example.myapplication.databinding.FragmentSportsBinding
import com.google.android.material.tabs.TabLayoutMediator

class InPlayFragment : Fragment() {
    private var _binding: FragmentInPlayBinding?=null
    private val binding get() = _binding!!
    private var _inPlayPagerAdapter:InPlayPagerAdapter?=null
    private val inPlayPagerAdapter get()=_inPlayPagerAdapter!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInPlayBinding.inflate(layoutInflater)
        bindViews()
        return binding.root
    }
   private fun bindViews(){
       _inPlayPagerAdapter = InPlayPagerAdapter(childFragmentManager, lifecycle)
       binding.vp.adapter = inPlayPagerAdapter
       TabLayoutMediator(binding.tabLayout, binding.vp) { tab, position ->
           when (position) {
               0 -> {
                   tab.text = "In-Play"
               }

               1 -> {
                   tab.text = "Today"
               }
               2 -> {
                   tab.text = "Tomorrow"
               }
               3 -> {
                   tab.text = "Result"
               }
           }

       }.attach()
    }
}