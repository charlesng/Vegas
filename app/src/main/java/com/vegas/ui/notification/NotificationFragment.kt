package com.vegas.ui.notification

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vegas.R
import com.vegas.ui.base.BaseFragment
import com.vegas.ui.detailrestaurant.DetailRestaurantActivity


class NotificationFragment : BaseFragment() {

    private var recyclerView: RecyclerView? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notification, container, false)
        //setup Recycler view
        val restaurant_container = view.findViewById<RecyclerView>(R.id.restaurant_container)
        recyclerView = restaurant_container
        val adapter = NotificationMyAdapter()
        adapter.onClickListener = View.OnClickListener { startActivity(Intent(activity, DetailRestaurantActivity::class.java)) }
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        /*
         * setup swipe refresh
         * https://stackoverflow.com/questions/25178329/recyclerview-and-swiperefreshlayout/25183693#25183693
         */
        swipeRefreshLayout = view?.findViewById(R.id.swipeContainer)
        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                val topRowVerticalPosition = if (recyclerView == null || recyclerView.childCount == 0) 0 else recyclerView.getChildAt(0).top
                swipeRefreshLayout!!.isEnabled = topRowVerticalPosition >= 0
            }

        })
        return view
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        fun newInstance(): NotificationFragment {
            val fragment = NotificationFragment()
            return fragment
        }
    }
}
