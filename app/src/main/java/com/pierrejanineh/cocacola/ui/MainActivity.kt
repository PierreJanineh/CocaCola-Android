package com.pierrejanineh.cocacola.ui

import android.os.Bundle
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.pierrejanineh.cocacola.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pierrejanineh.cocacola.R
import com.pierrejanineh.cocacola.ui.base.BaseActivity
import com.pierrejanineh.cocacola.ui.bottom_nav.ViewPagerAdapter

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        val pagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.apply {
            adapter = pagerAdapter
            isUserInputEnabled = false
            setPageTransformer(MarginPageTransformer(50))
        }

        val navView: BottomNavigationView = binding.bottomNavigationView
        navView.background = null

        navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> binding.viewPager.currentItem = 0
                R.id.navigation_shop -> binding.viewPager.currentItem = 1
                R.id.navigation_volunteering -> binding.viewPager.currentItem = 2
                R.id.navigation_games -> binding.viewPager.currentItem = 3
                else -> return@setOnItemSelectedListener false
            }
            true
        }

        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    binding.bottomNavigationView.selectedItemId = when (position) {
                        0 -> R.id.navigation_home
                        1 -> R.id.navigation_shop
                        2 -> R.id.navigation_volunteering
                        3 -> R.id.navigation_games
                        else -> R.id.navigation_home
                    }
                }
            }
        )
    }
}