package com.umbral.www.shape_drawing_tracker.utils

import android.support.v7.widget.RecyclerView
import androidx.recyclerview.selection.ItemKeyProvider

class ShapeKeyProvider(private val recyclerView: RecyclerView) : ItemKeyProvider<Long>(SCOPE_MAPPED) {

    override fun getKey(position: Int): Long? = recyclerView.adapter?.getItemId(position)

    override fun getPosition(key: Long): Int {
        val viewHolder = recyclerView.findViewHolderForItemId(key)
        return viewHolder?.layoutPosition ?: RecyclerView.NO_POSITION
    }

}