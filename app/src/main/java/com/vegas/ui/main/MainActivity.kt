package com.vegas.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView
import com.vegas.R
import com.vegas.ui.base.BaseActivity
import com.vegas.ui.bookmark.BookmarkFragment
import com.vegas.ui.browse.BrowseFragment
import com.vegas.ui.maps.MapsFragment
import com.vegas.ui.notification.NotificationFragment
import com.vegas.ui.search.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : BaseActivity() {

    private val viewPager: ViewPager?
        get() {
            val viewpager = main_pager
            return viewpager
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.my_toolbar)
        setupToolBar(toolbar)
        //setup navigation drawer
        setupNavigationDraer(toolbar)
        //setup the view pager
        val viewpager = main_pager
        viewpager.adapter = ScreenSlidePagerAdapter(supportFragmentManager)
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                supportActionBar?.show()
                when (position) {
                    0 -> {
                        toolbar_title.text = "Restaurant App"
                        toolbar?.menu?.clear()
                        menuInflater.inflate(R.menu.fragment_browse, optionsMenu)
                    }
                    1 -> {
                        toolbar?.menu?.clear()
                        supportActionBar?.hide()

                    }
                    2 -> {
                        toolbar_title.text = "Map"
                        toolbar?.menu?.clear()
                        menuInflater.inflate(R.menu.fragment_maps, optionsMenu)
                    }
                    3 -> {
                        toolbar_title.text = "Notification"
                        toolbar?.menu?.clear()
                        menuInflater.inflate(R.menu.fragment_notification, optionsMenu)
                    }
                    4 -> {
                        toolbar_title.text = "Bookmark"
                        toolbar?.menu?.clear()
                        menuInflater.inflate(R.menu.fragment_bookmark, optionsMenu)
                    }
                }
            }

        })
        //setup bottom navigation view
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        setupBottomNavigationView(bottomNavigationView)
    }

    private var optionsMenu: Menu? = null
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        optionsMenu = menu
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
            R.id.action_search -> Unit
            R.id.action_account -> Unit
        }
        return super.onOptionsItemSelected(item)
    }

    fun setupBottomNavigationView(bottomNavigationView: BottomNavigationView) {
        /*
         * Refer to https://github.com/armcha/LuseenBottomNavigation
         */
        val homeItem = BottomNavigationItem("Home", ContextCompat.getColor(this, R.color.theme), R.drawable.ic_home_black_24dp)
        val searchItem = BottomNavigationItem("Search", ContextCompat.getColor(this, R.color.theme), R.drawable.ic_search_black_24dp)
        val mapItem = BottomNavigationItem("Map", ContextCompat.getColor(this, R.color.theme), R.drawable.ic_location_on_black_24dp)
        val notificationItem = BottomNavigationItem("Notification", ContextCompat.getColor(this, R.color.theme), R.drawable.ic_notifications_none_black_24dp)
        val pinItem = BottomNavigationItem("Mark", ContextCompat.getColor(this, R.color.theme), R.drawable.ic_bookmark_black_24dp)
        bottomNavigationView.addTab(homeItem)
        bottomNavigationView.addTab(searchItem)
        bottomNavigationView.addTab(mapItem)
        bottomNavigationView.addTab(notificationItem)
        bottomNavigationView.addTab(pinItem)
        //bottom navigation view configuration
        bottomNavigationView.isColoredBackground(false)
        bottomNavigationView.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this, R.color.theme))
        bottomNavigationView.setOnBottomNavigationItemClickListener { item ->
            when (item) {
                0 -> {
                    viewPager?.currentItem = 0
                }
                1 -> {
                    viewPager?.currentItem = 1
                }
                2 -> {
                    viewPager?.currentItem = 2
                }
                3 -> {
                    viewPager?.currentItem = 3
                }
                4 -> {
                    viewPager?.currentItem = 4
                }
            }
        }
        bottomNavigationView.isWithText(false)
        bottomNavigationView.willNotRecreate(true);
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return BrowseFragment.newInstance()
                1 -> return SearchFragment.newInstance()
                2 -> return MapsFragment.newInstance()
                3 -> return NotificationFragment.newInstance()
                4 -> return BookmarkFragment.newInstance()
            }
            return BookmarkFragment.newInstance()
        }

        override fun getCount(): Int {
            return 5
        }

    }
}
