package com.vegas.ui.account

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.view.View
import com.vegas.R
import com.vegas.ui.base.BaseActivity
import com.vegas.ui.detailrestaurant.DetailRestaurantActivity
import kotlinx.android.synthetic.main.activity_account.*
import kotlinx.android.synthetic.main.inner_account_info.*

class AccountActivity : BaseActivity(), AppBarLayout.OnOffsetChangedListener {
    var mMaxScrollSize: Int = 0
    private val PERCENTAGE_TO_ANIMATE_AVATAR = 10
    var mIsAvatarShown: Boolean = false
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        if (mMaxScrollSize == 0)
            if (appBarLayout != null) mMaxScrollSize = appBarLayout.totalScrollRange
        val percentage = Math.abs(verticalOffset) * 100 / mMaxScrollSize
        if (percentage >= PERCENTAGE_TO_ANIMATE_AVATAR && mIsAvatarShown) {
            mIsAvatarShown = false
            account_image.animate()
                    .scaleY(0f).scaleX(0f)
                    .setDuration(200)
                    .start()
        }
        if (percentage <= PERCENTAGE_TO_ANIMATE_AVATAR && !mIsAvatarShown) {
            mIsAvatarShown = true
            account_image.animate()
                    .scaleY(1f).scaleX(1f)
                    .setDuration(200)
                    .start()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        setupToolBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        main_appbar.addOnOffsetChangedListener(this)
        mMaxScrollSize = main_appbar.totalScrollRange
        val adapter = MyRestaurantMyAdapter()
        adapter.onClickListener = View.OnClickListener { startActivity(Intent(this, DetailRestaurantActivity::class.java)) }
        restaurant_container!!.adapter = adapter
        restaurant_container!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return false
    }
}
