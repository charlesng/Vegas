package com.vegas.ui.detailrestaurant

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.vegas.R
import com.vegas.ui.direct.DirectActivity

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [RestaurantOverviewFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [RestaurantOverviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RestaurantOverviewFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_restaurant_overview, container, false)
        val directImg = inflate.findViewById<ImageView>(R.id.directImg)
        directImg.setOnClickListener { view -> startActivity(Intent(activity, DirectActivity::class.java)) }
        return inflate
    }


    companion object {
        fun newInstance(): RestaurantOverviewFragment {
            val fragment = RestaurantOverviewFragment()
            return fragment
        }
    }
}// Required empty public constructor
