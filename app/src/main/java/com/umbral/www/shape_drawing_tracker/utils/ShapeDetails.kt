package com.umbral.www.shape_drawing_tracker.utils

import androidx.recyclerview.selection.ItemDetailsLookup

class ShapeDetails(private var position: Int, var key: String) : ItemDetailsLookup.ItemDetails<String>() {

    override fun getPosition(): Int {
        return position
    }

    override fun getSelectionKey(): String? {
        return key
    }

}