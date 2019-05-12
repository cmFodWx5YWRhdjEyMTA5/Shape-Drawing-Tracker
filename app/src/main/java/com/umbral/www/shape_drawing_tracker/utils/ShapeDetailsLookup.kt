package com.umbral.www.shape_drawing_tracker.utils

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import com.umbral.www.shape_drawing_tracker.adapters.ShapeAdapter

class ShapeDetailsLookup(private var recyclerView: RecyclerView) : ItemDetailsLookup<String>() {

    override fun getItemDetails(e: MotionEvent): ItemDetails<String>? {
        val view: View? = recyclerView.findChildViewUnder(e.x, e.y)
        val holder: RecyclerView.ViewHolder = recyclerView.getChildViewHolder(view!!)
        if (holder is ShapeAdapter.ShapeViewHolder) {
            return holder.getShapeDetails()
        }
        return null
    }

}