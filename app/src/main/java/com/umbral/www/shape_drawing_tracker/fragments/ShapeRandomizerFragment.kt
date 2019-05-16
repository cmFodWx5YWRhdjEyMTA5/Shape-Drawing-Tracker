package com.umbral.www.shape_drawing_tracker.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import com.umbral.www.shape_drawing_tracker.R

class ShapeRandomizerFragment : Fragment() {

    private lateinit var blinkingArrow: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_shape_randomizer, container, false)
        blinkingArrow = rootView.findViewById(R.id.blinking_arrow)

        setArrowAnimation()

        return rootView
    }

    /*
    *  Make the arrow blink to indicate the user he has to swipe
    *  to access the Shape Selection screen
    * */
    private fun setArrowAnimation() {
        val animation = AlphaAnimation(1f, 0f)
        animation.apply {
            duration = 1000
            interpolator = LinearInterpolator()
            repeatCount = Animation.INFINITE
            repeatMode = Animation.REVERSE
        }
        blinkingArrow.startAnimation(animation)
    }

}


