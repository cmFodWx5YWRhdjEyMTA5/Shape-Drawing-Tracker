package com.umbral.www.shape_drawing_tracker.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.umbral.www.shape_drawing_tracker.fragments.ShapeRandomizerFragment
import com.umbral.www.shape_drawing_tracker.fragments.ShapeSelectionFragment

class ShapePagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    companion object {
        internal const val PAGE_COUNT = 2
    }

    override fun getItem(position: Int): Fragment? = when (position) {
        0 -> ShapeRandomizerFragment()
        1 -> ShapeSelectionFragment()
        else -> null
    }

    override fun getCount(): Int = PAGE_COUNT
}