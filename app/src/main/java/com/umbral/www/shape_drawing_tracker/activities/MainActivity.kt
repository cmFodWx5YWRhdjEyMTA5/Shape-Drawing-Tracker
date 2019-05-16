package com.umbral.www.shape_drawing_tracker.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View.LAYER_TYPE_NONE
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.adapters.ShapePagerAdapter
import com.umbral.www.shape_drawing_tracker.models.ShapePageTransformer

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.main_pager)
        viewPager.setPageTransformer(false, ShapePageTransformer(), LAYER_TYPE_NONE)
        viewPager.adapter = ShapePagerAdapter(supportFragmentManager)
    }

    /*
     * Handle Return button in the view pager to go back to main screen
     */
    override fun onBackPressed() {
        if (viewPager.currentItem == 0) super.onBackPressed() else viewPager.currentItem--
    }
}
