package com.umbral.www.shape_drawing_tracker.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.adapters.ShapeAdapter
import com.umbral.www.shape_drawing_tracker.models.Shape
import com.umbral.www.shape_drawing_tracker.utils.ShapeDetailsLookup

class ShapeSelectionFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val shapeData: ArrayList<Shape> = fillShapeDataSet()

    private lateinit var keyProvider: ItemKeyProvider<String>
    private lateinit var selectionTracker: SelectionTracker<String>

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

        selectionTracker = SelectionTracker.Builder<String>(
            "shape_selection",
            recyclerView,
            keyProvider,
            ShapeDetailsLookup(recyclerView),
            StorageStrategy.createStringStorage()
        ).build()

        return rootView
    }

    private fun fillShapeDataSet(): ArrayList<Shape> {
        val shapeList: ArrayList<Shape> = ArrayList()
        shapeList.add(Shape("Circle", R.drawable.circle_shape, false))
        shapeList.add(Shape("Horizontal Oval", R.drawable.horizontal_oval_shape, false))
        shapeList.add(Shape("Vertical Oval", R.drawable.vertical_oval_shape, false))
        shapeList.add(Shape("Diagonal Right Oval", R.drawable.diagonal_right_oval_shape, false))
        shapeList.add(Shape("Diagonal Left Oval", R.drawable.diagonal_left_oval_shape, false))
        shapeList.add(Shape("Thin Oval", R.drawable.thin_oval_shape, false))
        shapeList.add(Shape("Large Oval", R.drawable.large_oval_shape, false))
        return shapeList
    }

}



