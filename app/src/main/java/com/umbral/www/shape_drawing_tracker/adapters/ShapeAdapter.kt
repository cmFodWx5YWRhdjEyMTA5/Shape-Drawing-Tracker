package com.umbral.www.shape_drawing_tracker.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.models.Shape

class ShapeAdapter(private var shapeData: ArrayList<Shape>) : RecyclerView.Adapter<ShapeAdapter.ShapeViewHolder>() {

    class ShapeViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        internal var shapeName: TextView = itemView.findViewById(R.id.shape_name)
        internal var shapeThumbnail: ImageView = itemView.findViewById(R.id.shape_thumbnail)
        internal var shapeStatus: Boolean = false
        internal var shapeCardContainer: CardView = itemView.findViewById(R.id.shape_card_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShapeViewHolder {
        val shapeView: CardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.shape_layout, parent, false) as CardView
        return ShapeViewHolder(shapeView)
    }

    override fun onBindViewHolder(holder: ShapeViewHolder, position: Int) {
        holder.shapeName.text = shapeData[position].mShapeName
        holder.shapeThumbnail.setImageResource(shapeData[position].mShapeImage)
        holder.shapeStatus = shapeData[position].mShapeStatus
    }

    override fun getItemCount(): Int {
        return shapeData.size
    }
}




