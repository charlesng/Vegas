package com.vegas.ui.detailrestaurant

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.vegas.R
import com.vegas.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_restaurant.*
import kotlinx.android.synthetic.main.toolbar.*


class DetailRestaurantActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_restaurant)
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setupToolBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        //setup the view pager
        val viewpager = detail_pager
        viewpager.adapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        toolbar_title.text = "Overview"
                        toolbar?.menu?.clear()
                        menuInflater.inflate(R.menu.fragment_restaurant_overview, optionsMenu)
                    }
                    1 -> {
                        toolbar_title.text = "Menu"
                        toolbar?.menu?.clear()
                        menuInflater.inflate(R.menu.fragment_restaurant_menu, optionsMenu)
                    }
                    2 -> {
                        toolbar_title.text = "Review"
                        toolbar?.menu?.clear()
                        menuInflater.inflate(R.menu.fragment_restaurant_review, optionsMenu)
                    }
                }
            }

        })
        val bottomNavigationView = bottom_navigation
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_overview -> {
                    viewpager.currentItem = 0
                }
                R.id.action_menu -> {
                    viewpager.currentItem = 1
                }
                R.id.action_review -> {
                    viewpager.currentItem = 2
                }
            }
            false
        }
    }

    private var optionsMenu: Menu? = null
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        optionsMenu = menu
        menuInflater.inflate(R.menu.activity_detail_restaurant, optionsMenu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return RestaurantOverviewFragment.newInstance()
                }
                1 -> {
                    return RestaurantMenuFragment.newInstance()
                }
                2 -> {
                    return RestaurantReviewFragment.newInstance()
                }
            }
            return RestaurantReviewFragment.newInstance()
        }

        override fun getCount(): Int {
            return 3
        }

    }
}
