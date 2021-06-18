package com.example.kotlindavn10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlindavn10.adapter.MainFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var mainFragmentAdapter: MainFragmentAdapter
    lateinit var viewPager:ViewPager2;
    lateinit var tabLayout: TabLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager = findViewById(R.id.pager)
        tabLayout = findViewById(R.id.tab_layout)
        mainFragmentAdapter = MainFragmentAdapter(activity = this)

        viewPager.adapter = mainFragmentAdapter
        TabLayoutMediator(tabLayout,viewPager){tab,position ->
            tab.text = "TAB $position"

        }.attach()

    }
}