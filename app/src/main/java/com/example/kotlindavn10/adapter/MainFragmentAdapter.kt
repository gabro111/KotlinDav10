package com.example.kotlindavn10.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlindavn10.fragment.FirstFragment
import com.example.kotlindavn10.fragment.SecondFragment

class MainFragmentAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int  = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> FirstFragment()
            1-> SecondFragment()
            else -> FirstFragment()
        }
    }
}