package com.umbral.www.shape_drawing_tracker.models

class Shape(var mShapeName: String, var mShapeImage: Int, var mShapeStatus: Boolean) {

    /**
    * Invert the status of the selected Shape
    */
    fun invertSelection() {
        this.mShapeStatus = !mShapeStatus
    }

}