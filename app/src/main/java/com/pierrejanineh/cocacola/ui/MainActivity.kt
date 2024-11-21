package com.pierrejanineh.cocacola.ui

import android.os.Bundle
import com.pierrejanineh.cocacola.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pierrejanineh.cocacola.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.bottomNavigationView
        navView.background = null
    }
}