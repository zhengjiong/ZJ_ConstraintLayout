package com.zj.example.constraintlayout

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.concurrent.TimeUnit

/**
 *
 * CreateTime: 17/11/15 08:44
 * @author zhengjiong
 */
class CircleExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.demo12_circle_layout)

        val earth = findViewById<AppCompatImageView>(R.id.earth)
        val mars = findViewById<AppCompatImageView>(R.id.mars)
        val saturn = findViewById<AppCompatImageView>(R.id.saturn)

        val animEatch = createCircleAnim(earth, TimeUnit.SECONDS.toMillis(2))
        val animMars = createCircleAnim(mars, TimeUnit.SECONDS.toMillis(6))
        val animSaturn = createCircleAnim(saturn, TimeUnit.SECONDS.toMillis(12))

        animEatch.start()
        animMars.start()
        animSaturn.start()
    }

    /**
     * 会卡顿, 没有找到解决方法
     */
    fun createCircleAnim(view: View, duration: Long): ValueAnimator {
        val valueAnimator = ValueAnimator.ofInt(0, 359)

        valueAnimator.addUpdateListener { animation: ValueAnimator ->
            val value = animation.animatedValue.toString().toInt()
            val layoutParam = view.layoutParams as ConstraintLayout.LayoutParams
            layoutParam.circleAngle = value.toFloat()
            view.layoutParams = layoutParam
            //println((view.layoutParams as ConstraintLayout.LayoutParams).circleAngle )
        }

        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.duration = duration

        return valueAnimator
    }
}