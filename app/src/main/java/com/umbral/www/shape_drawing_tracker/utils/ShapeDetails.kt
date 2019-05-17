package com.umbral.www.shape_drawing_tracker.utils

import androidx.recyclerview.selection.ItemDetailsLookup

class ShapeDetails(private var position: Int, private var itemId: Long) : ItemDetailsLookup.ItemDetails<Long>() {

    override fun getPosition(): Int = position

    override fun getSelectionKey(): Long? = itemId

}