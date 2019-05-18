package com.umbral.www.shape_drawing_tracker.adapters

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.selection.SelectionTracker
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.models.Shape
import com.umbral.www.shape_drawing_tracker.utils.ShapeDetails

class ShapeAdapter(private var shapeData: ArrayList<Shape>) : RecyclerView.Adapter<ShapeAdapter.ShapeViewHolder>() {

    var selectionTracker: SelectionTracker<Long>? = null

    companion object {
        var shapeListToRandomize: ArrayList<Shape> = ArrayList()
    }

    init {
        setHasStableIds(true)
    }

    class ShapeViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private var shapeName: TextView = itemView.findViewById(R.id.shape_name)
        private var shapeThumbnail: ImageView = itemView.findViewById(R.id.shape_thumbnail)
        private var shapeContainer: CardView = itemView.findViewById(R.id.shape_card_view)

        fun getShapeDetails(): ShapeDetails = ShapeDetails(adapterPosition, itemId)

        fun bindShapeData(name: String, thumbnail: Int, isActivated: Boolean = false) {
            shapeName.text = name
            shapeThumbnail.setImageResource(thumbnail)
            shapeContainer.isActivated = isActivated
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShapeViewHolder {
        val shapeView: CardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.shape_layout, parent, false) as CardView
        return ShapeViewHolder(shapeView)
    }

    override fun onBindViewHolder(holder: ShapeViewHolder, position: Int) {
        val name = shapeData[position].mShapeName
        val thumbnail = shapeData[position].mShapeImage

        selectionTracker?.let {
            holder.bindShapeData(name, thumbnail, it.isSelected(position.toLong()))
            if (it.isSelected(position.toLong())) shapeListToRandomize.add(Shape(name, thumbnail))
            else shapeListToRandomize.remove(Shape(name, thumbnail))
        }
    }

    override fun getItemCount(): Int = shapeData.size

    override fun getItemId(position: Int): Long = position.toLong()

}




