package com.vegas.ui.account

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vegas.R
import com.vegas.ui.base.BaseMyAdapter


/**
 * Created by PIGFAMILY on 9/1/2018.
 */
class MyRestaurantMyAdapter : BaseMyAdapter<MyRestaurantMyAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRestaurantMyAdapter.ViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.item_myrestaurant1, parent, false)
        val viewHolder = ViewHolder(itemView)
        viewHolder.itemView.setOnClickListener(onClickListener)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyRestaurantMyAdapter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View?) : super(itemView)
    }
}