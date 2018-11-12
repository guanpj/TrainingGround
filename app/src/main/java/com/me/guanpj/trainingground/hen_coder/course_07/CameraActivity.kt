package com.me.guanpj.trainingground.hen_coder.course_07

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Activity
import android.os.Bundle
import com.me.guanpj.trainingground.R
import kotlinx.android.synthetic.main.activity_camera.*

class CameraActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        val bottomFlipAnimator = ObjectAnimator.ofFloat(view, "bottomFlip", 45f)
        bottomFlipAnimator.setDuration(1500)

        val flipRotationAnimator = ObjectAnimator.ofFloat(view, "flipRotation", 270f)
        flipRotationAnimator.setDuration(6000)

        val topFlipAnimator = ObjectAnimator.ofFloat(view, "topFlip", -45f)
        topFlipAnimator.setDuration(1500)

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        animatorSet.startDelay = 1000
        animatorSet.start()
        animatorSet.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                view.reset()
                animation.start()
            }
        })
    }
}