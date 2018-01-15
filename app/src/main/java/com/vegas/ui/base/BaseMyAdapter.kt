package com.vegas.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by PIGFAMILY on 12/1/2018.
 */
abstract class BaseMyAdapter<T : RecyclerView.ViewHolder> : RecyclerView.Adapter<T>() {
    var onClickListener: View.OnClickListener? = null
}