package com.umbral.www.shape_drawing_tracker.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.umbral.www.shape_drawing_tracker.R
import com.umbral.www.shape_drawing_tracker.adapters.ShapeAdapter
import kotlin.random.Random.Default.nextInt

class ShapeRandomizerFragment : Fragment(), View.OnClickListener {

    private lateinit var blinkingArrow: ImageView
    private lateinit var shapeImageView: ImageView
    private lateinit var shapeTextView: TextView
    private lateinit var randomizeButton: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_shape_randomizer, container, false)
        blinkingArrow = rootView.findViewById(R.id.blinking_arrow)
        shapeImageView = rootView.findViewById(R.id.shape_image_view)
        shapeTextView = rootView.findViewById(R.id.shape_text_view)
        randomizeButton = rootView.findViewById(R.id.randomize_button)

        setArrowAnimation()

        randomizeButton.setOnClickListener(this)

        return rootView
    }

    /*
    * Handle Randomize button
    * */
    override fun onClick(v: View?) {
        if (ShapeAdapter.shapeListToRandomize.size > 0 ) {
            val randomNumber: Int = nextInt(0, ShapeAdapter.shapeListToRandomize.size)
            ShapeAdapter.shapeListToRandomize[randomNumber].mShapeImage.let { shapeImageView.setImageResource(it) }
            shapeTextView.text = ShapeAdapter.shapeListToRandomize[randomNumber].mShapeName
        }
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



