package com.vegas.ui.bookmark

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vegas.R
import com.vegas.ui.base.BaseMyAdapter
import com.vegas.ui.bookmark.BookmarkMyAdapter.ViewHolder

/**
 * Created by PIGFAMILY on 10/1/2018.
 */


class BookmarkMyAdapter : BaseMyAdapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.item_bookmark1, parent, false)
        val viewHolder = ViewHolder(itemView)
        viewHolder.itemView.setOnClickListener(onClickListener)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return 10
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        constructor(itemView: View?) : super(itemView)
    }
}
