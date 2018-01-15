package com.vegas.ui.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.vegas.R
import com.vegas.ui.account.AccountActivity
import kotlinx.android.synthetic.main.toolbar.*


open class BaseActivity : AppCompatActivity() {

    protected fun setupNavigationDraer(toolbar: Toolbar) {
        // Create the AccountHeader
        val profileDrawerItem = ProfileDrawerItem()
                .withName("nguyenlinhdl")
                .withEmail("Male,Hanol")
                .withIcon(R.drawable.follower_icon)
                .withOnDrawerItemClickListener({ view, position, drawerItem ->
                    val intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                    false
                })
        val headerResult = AccountHeaderBuilder()
                .withActivity(this)
                .withTextColorRes(R.color.md_black_1000)
                .withHeightDp(200)
                .withSelectionListEnabledForSingleProfile(false)
                .addProfiles(
                        profileDrawerItem
                )
                .withOnAccountHeaderSelectionViewClickListener { view, profile ->
                    val intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                    false
                }
                .build()
        val item1 = PrimaryDrawerItem().withIdentifier(1).withName("Manage")
        val item2 = PrimaryDrawerItem().withIdentifier(2).withName("Languages")
        val item3 = PrimaryDrawerItem().withIdentifier(3).withName("Contact US")
        val item4 = PrimaryDrawerItem().withIdentifier(4).withName("Help")
        val item5 = PrimaryDrawerItem().withIdentifier(5).withName("Logout")
        DrawerBuilder(this)
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withSliderBackgroundDrawableRes(R.drawable.drawer_bg)
                .addDrawerItems(item1, item2, item3, item4, item5)
                .withSelectedItem(-1)
                .withOnDrawerItemClickListener({ view, position, drawerItem ->
                    when (position) {
                        1 -> {
                            false
                        }
                        2 -> {
                            false
                        }
                        3 -> {
                            false
                        }
                        4 -> {
                            false
                        }
                        5 -> {
                            this.finish()
                        }
                    }
                    false
                })
                .build()
    }


    protected fun setupToolBar(toolbar: Toolbar?) {
        /*
         * Center the title and move the default title to the toolbar
         * https://stackoverflow.com/a/26548766/2877822
         */
        setSupportActionBar(toolbar)
        toolbar_title.text = supportActionBar!!.title
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }
}
