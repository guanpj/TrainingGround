package com.me.guanpj.trainingground.hen_coder.course_06

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Dashboard(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    internal var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    internal var dash = Path()
    internal var effect: PathDashPathEffect

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = Utils.dp2px(2f)
        dash.addRect(0f, 0f, Utils.dp2px(2f), Utils.dp2px(10f), Path.Direction.CW)
        val arc = Path()
        arc.addArc(width / 2 - RADIUS, height / 2 - RADIUS, width / 2 + RADIUS, height / 2 + RADIUS, (90 + ANGLE / 2).toFloat(), (360 - ANGLE).toFloat())
        val pathMeasure = PathMeasure(arc, false)
        effect = PathDashPathEffect(dash, (pathMeasure.length - Utils.dp2px(2f)) / 20, 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 画线
        canvas.drawArc(width / 2 - RADIUS,
                height / 2 - RADIUS,
                width / 2 + RADIUS,
                height / 2 + RADIUS,
                (90 + ANGLE / 2).toFloat(),
                (360 - ANGLE).toFloat(),
                false,
                paint)

        // 画刻度
        paint.pathEffect = effect
        canvas.drawArc(width / 2 - RADIUS,
                height / 2 - RADIUS,
                width / 2 + RADIUS,
                height / 2 + RADIUS,
                (90 + ANGLE / 2).toFloat(),
                (360 - ANGLE).toFloat(),
                false,
                paint)
        paint.pathEffect = null

        // 画指针
        canvas.drawLine((width / 2).toFloat(), (height / 2).toFloat(),
                Math.cos(Math.toRadians(getAngleFromMark(5).toDouble())).toFloat() * LENGTH + width / 2,
                Math.sin(Math.toRadians(getAngleFromMark(5).toDouble())).toFloat() * LENGTH + height / 2,
                paint)

    }

    internal fun getAngleFromMark(mark: Int): Int {
        return (90f + ANGLE.toFloat() / 2 + (360 - ANGLE.toFloat()) / 20 * mark).toInt()
    }

    companion object {
        private val ANGLE = 120
        private val RADIUS = Utils.dp2px(150f)
        private val LENGTH = Utils.dp2px(100f)
    }
}
