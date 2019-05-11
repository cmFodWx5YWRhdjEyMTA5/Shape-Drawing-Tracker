package com.umbral.www.shape_drawing_tracker.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.adapters.ShapePagerAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.main_pager)
        viewPager.adapter = ShapePagerAdapter(supportFragmentManager)
    }

}
