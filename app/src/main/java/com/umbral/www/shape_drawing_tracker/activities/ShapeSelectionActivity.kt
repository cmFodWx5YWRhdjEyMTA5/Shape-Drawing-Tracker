package com.umbral.www.shape_drawing_tracker.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.adapters.ShapeAdapter
import com.umbral.www.shape_drawing_tracker.models.Shape

class ShapeSelectionActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private val shapeData: ArrayList<Shape> = fillShapeDataSet()

    companion object {
        internal const val GRID_LAYOUT_SPAN_COUNT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shape_selection)

        viewManager = GridLayoutManager(
            this,
            GRID_LAYOUT_SPAN_COUNT
        )

        viewAdapter = ShapeAdapter(shapeData)

        recyclerView = findViewById<RecyclerView>(R.id.recycle_shape).apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

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
