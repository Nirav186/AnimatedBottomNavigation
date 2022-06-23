package com.nirav.bottomnavigation.activity

import android.util.Log
import androidx.fragment.app.Fragment
import com.example.bottomnavigationdemo.ActBase
import com.nirav.bottomnavigation.fragment.FirstFragment
import com.nirav.bottomnavigation.fragment.SecondFragment
import com.nirav.bottomnavigation.fragment.ThirdFragment
import com.nirav.bottomnavigation.R
import com.nirav.bottomnavigation.databinding.ActivityMainBinding
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : ActBase<ActivityMainBinding>() {

    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private val thirdFragment = ThirdFragment()

    override fun setViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun bindObjects() {

    }

    override fun bindListeners() {

        binding.bottomBar.onTabSelected = {
            Log.d("bottom_bar", "Selected tab: " + it.title)
        }

        binding.bottomBar.onTabReselected = {
            Log.d("bottom_bar", "Reselected tab: " + it.title)
        }

        binding.bottomBar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(
                lastIndex: Int,
                lastTab: AnimatedBottomBar.Tab?,
                newIndex: Int,
                newTab: AnimatedBottomBar.Tab
            ) {
                Log.d("bottom_bar", "Selected index: $newIndex, title: ${newTab.title}")
                when (newIndex) {
                    0 -> {
                        loadFragment(firstFragment)
                    }
                    1 -> {
                        loadFragment(secondFragment)
                    }
                    2 -> {
                        loadFragment(thirdFragment)
                    }
                }
            }
        })
    }

    override fun bindMethods() {
        loadFragment(firstFragment)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerView, fragment)
            .commit()
    }

}