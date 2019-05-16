package com.umbral.www.shape_drawing_tracker.models

import android.support.v4.view.ViewPager
import android.view.View

class ShapePageTransformer : ViewPager.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        when {
            position > 0 -> {
                page.translationX = 0f
            }
            else -> {
                page.translationX = -position * pageWidth
            }
        }
    }
}