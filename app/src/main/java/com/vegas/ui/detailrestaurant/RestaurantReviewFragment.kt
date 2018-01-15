package com.vegas.ui.detailrestaurant

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vegas.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RestaurantReviewFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RestaurantReviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantReviewFragment : Fragment() {

    private var recyclerView: RecyclerView? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_restaurant_review, container, false)
        recyclerView = view.findViewById(R.id.restaurant_container)
        recyclerView!!.adapter = RestaurantReviewMyAdapter()
        recyclerView!!.layoutManager = LinearLayoutManager(activity)
        /*
         * setup swipe refresh
         * https://stackoverflow.com/questions/25178329/recyclerview-and-swiperefreshlayout/25183693#25183693
         */
        swipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.swipeContainer)
        recyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                val topRowVerticalPosition = if (recyclerView == null || recyclerView.childCount == 0) 0 else recyclerView.getChildAt(0).top
                swipeRefreshLayout!!.isEnabled = topRowVerticalPosition >= 0
            }
        })
        return view
    }
    companion object {


        fun newInstance(): RestaurantReviewFragment {
            val fragment = RestaurantReviewFragment()
            return fragment
        }
    }
}// Required empty public constructor
