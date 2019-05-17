package com.umbral.www.shape_drawing_tracker.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionPredicates
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.adapters.ShapeAdapter
import com.umbral.www.shape_drawing_tracker.models.Shape
import com.umbral.www.shape_drawing_tracker.utils.ShapeDetailsLookup
import com.umbral.www.shape_drawing_tracker.utils.ShapeKeyProvider

class ShapeSelectionFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val shapeData: ArrayList<Shape> = fillShapeDataSet()
    private lateinit var mselectionTracker: SelectionTracker<Long>

    companion object {
        internal const val GRID_LAYOUT_SPAN_COUNT = 2
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_shape_selection, container, false)

        viewManager = GridLayoutManager(
            activity,
            GRID_LAYOUT_SPAN_COUNT
        )

        viewAdapter = ShapeAdapter(shapeData)

        recyclerView = rootView.findViewById<RecyclerView>(R.id.recycle_shape).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        mselectionTracker = SelectionTracker.Builder<Long>(
            "ShapeSelection",
            recyclerView,
            ShapeKeyProvider(recyclerView),
            ShapeDetailsLookup(recyclerView),
            StorageStrategy.createLongStorage()
        ).withSelectionPredicate(
            SelectionPredicates.createSelectAnything()
        ).build()

        (viewAdapter as ShapeAdapter).selectionTracker = mselectionTracker

        if (savedInstanceState!=null){
            mselectionTracker.onRestoreInstanceState(savedInstanceState)
        }

        return rootView
    }

    private fun fillShapeDataSet(): ArrayList<Shape> {
        val shapeList: ArrayList<Shape> = ArrayList()
        shapeList.add(Shape("Circle", R.drawable.circle_shape))
        shapeList.add(Shape("Horizontal Oval", R.drawable.horizontal_oval_shape))
        shapeList.add(Shape("Vertical Oval", R.drawable.vertical_oval_shape))
        shapeList.add(Shape("Diagonal Right Oval", R.drawable.diagonal_right_oval_shape))
        shapeList.add(Shape("Diagonal Left Oval", R.drawable.diagonal_left_oval_shape))
        shapeList.add(Shape("Thin Oval", R.drawable.thin_oval_shape))
        shapeList.add(Shape("Large Oval", R.drawable.large_oval_shape))
        return shapeList
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mselectionTracker.onSaveInstanceState(outState)
    }
}



