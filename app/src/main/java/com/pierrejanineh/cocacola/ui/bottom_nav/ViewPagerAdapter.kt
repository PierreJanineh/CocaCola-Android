package com.pierrejanineh.cocacola.ui.bottom_nav

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.pierrejanineh.cocacola.ui.fragments.GamesFragment
import com.pierrejanineh.cocacola.ui.fragments.GiftShopFragment
import com.pierrejanineh.cocacola.ui.fragments.home.HomeFragment
import com.pierrejanineh.cocacola.ui.fragments.VolunteeringFragment

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeFragment()
            1 -> GiftShopFragment()
            2 -> VolunteeringFragment()
            3 -> GamesFragment()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }
}