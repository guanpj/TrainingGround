package com.me.guanpj.trainingground.hen_coder.course_06

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import com.me.guanpj.trainingground.Utils


class PieChartView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private val RADIUS = Utils.dp2px(150f).toInt()
    private val LENGTH = Utils.dp2px(20f).toInt()
    private val PULLED_OUT_INDEX = 2

    var paint = Paint(ANTI_ALIAS_FLAG)
    var bounds = RectF()
    var angles = floatArrayOf(60f, 100f, 120f, 80f)
    var colors = intArrayOf(Color.parseColor("#2979FF"), Color.parseColor("#C2185B"), Color.parseColor("#009688"), Color.parseColor("#FF8F00"))

    init {

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        bounds.set(getWidth() / 2f - RADIUS, getHeight() / 2f - RADIUS, getWidth() / 2f + RADIUS, getHeight() / 2f + RADIUS);
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        var currentAngle: Float = 0f
        for ((index, angle) in angles.withIndex()) {
            paint.color = colors[index]
            canvas.save()
            if (index == PULLED_OUT_INDEX) {
                canvas.translate((Math.cos(Math.toRadians((currentAngle + angle / 2).toDouble())) * LENGTH).toFloat(),
                        Math.sin(Math.toRadians((currentAngle + angle / 2).toDouble())).toFloat() * LENGTH)
            }
            canvas.drawArc(bounds, currentAngle, angle, true, paint)
            canvas.restore()
            currentAngle += angle
        }
    }
}