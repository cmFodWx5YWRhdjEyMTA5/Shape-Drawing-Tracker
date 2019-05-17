package com.umbral.www.shape_drawing_tracker.utils

import android.support.v7.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import com.umbral.www.shape_drawing_tracker.adapters.ShapeAdapter

class ShapeDetailsLookup(private var recyclerView: RecyclerView) : ItemDetailsLookup<Long>() {

    override fun getItemDetails(e: MotionEvent): ItemDetails<Long>? {
        val view: View? = recyclerView.findChildViewUnder(e.x, e.y)
        if (view != null) {
            return (recyclerView.getChildViewHolder(view) as ShapeAdapter.ShapeViewHolder).getShapeDetails()
        }
        return null
    }

}