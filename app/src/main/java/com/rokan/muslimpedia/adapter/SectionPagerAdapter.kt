package com.rokan.muslimpedia.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rokan.muslimpedia.ui.home.BusinessFragment
import com.rokan.muslimpedia.ui.home.SportFragment
import com.rokan.muslimpedia.ui.home.CommonFragment
import com.rokan.muslimpedia.ui.home.WarningFragment

class SectionPagerAdapter(fm : FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CommonFragment()
            1 -> BusinessFragment()
            2 -> SportFragment()
            3 -> WarningFragment()
            else -> CommonFragment()
        }
    }
}