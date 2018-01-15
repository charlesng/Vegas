package com.vegas.ui.maps

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.vegas.R
import com.vegas.ui.base.BaseFragment
import com.vegas.ui.detailrestaurant.DetailRestaurantActivity


class MapsFragment : BaseFragment(), OnMapReadyCallback {
    private var mMap: GoogleMap? = null
    private var restaurant_container : RecyclerView? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_maps,container,false)
        restaurant_container = view.findViewById(R.id.restaurant_container)
        val mapFragment = childFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        val adapter = MapRestaurantMyAdapter()
        adapter.onClickListener = View.OnClickListener { startActivity(Intent(activity, DetailRestaurantActivity::class.java)) }
        restaurant_container!!.adapter = adapter
        restaurant_container!!.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        return view
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney, Australia, and move the camera.
        val sydney = LatLng(-34.0, 151.0)
        mMap!!.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        fun newInstance(): MapsFragment {
            val fragment = MapsFragment()
            return fragment
        }
    }
}
