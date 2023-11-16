package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.inplay.InplayFilterFragment
import com.example.myapplication.model.FilterInInplay

class InPlayPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    private val fragList = listOf<Fragment>(
        InplayFilterFragment.newInstance(FilterInInplay.INPLAY.name),
        InplayFilterFragment.newInstance(FilterInInplay.TODAY.name),
        InplayFilterFragment.newInstance(FilterInInplay.TOMORROW.name),
        InplayFilterFragment.newInstance(FilterInInplay.RESULT.name)
    )

    override fun getItemCount(): Int {
        return fragList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragList[position]
    }
}