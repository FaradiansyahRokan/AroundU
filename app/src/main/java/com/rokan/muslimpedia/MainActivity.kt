package com.rokan.muslimpedia

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.rokan.muslimpedia.adapter.SectionPagerAdapter
import com.rokan.muslimpedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setUpViewPager()
    }

    private fun setUpViewPager() {

        val adapter = SectionPagerAdapter(this)
        binding.vpNews.adapter = adapter

        TabLayoutMediator(binding.tabs, binding.vpNews) { tab, position ->
            when (position) {
                0 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_home_24)
                1 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_bisnis)
                2 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.ic_sports)
                3 -> tab.icon = ContextCompat.getDrawable(this, R.drawable.bx_code_alt)
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.menu_search)?.actionView as androidx.appcompat.widget.SearchView).apply{
            setSearchableInfo(searchManager.getSearchableInfo(componentName))

            return true
        }
    }
}