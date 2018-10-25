package com.me.guanpj.trainingground.hen_coder.course_06

import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View

class DashBoardView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    companion object {
        private val ANGLE = 240f
        private val RADIUS = Utils.dp2px(150f)
        private val LENGTH = Utils.dp2px(100f)
        private var markWidth = Utils.dp2px(2f)
        private var markHeight = Utils.dp2px(20f)
        private var markCount = 20
    }

    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var dashPath = Path()
    private lateinit var dashEffect: PathDashPathEffect
    private lateinit var dashBoardBound: RectF

    init {

        dashBoardBound = RectF(width/2 - RADIUS, height/2 - RADIUS, width/2 + RADIUS, height/2 + RADIUS)

        paint.style = Paint.Style.STROKE
        paint.strokeWidth = Utils.dp2px(2f)

        dashPath.addRect(0f, 0f, markWidth, markHeight, Path.Direction.CW)
        var path = Path()
        path.addArc(dashBoardBound, 150f,
                ANGLE)
        var pathMeasure = PathMeasure(path, false)
        dashEffect = PathDashPathEffect(dashPath,(pathMeasure.length - markWidth) / markCount, 0f, PathDashPathEffect.Style.ROTATE)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        dashBoardBound = RectF(width/2 - RADIUS, height/2 - RADIUS, width/2 + RADIUS, height/2 + RADIUS)

        canvas.drawArc(dashBoardBound,
                150f,
                ANGLE,
                false,
                paint)

        paint.setPathEffect(dashEffect)

        canvas.drawArc(dashBoardBound,
                150f,
                ANGLE,
                false,
                paint)

        paint.setPathEffect(null)

        /*canvas.drawArc(100f, 100f, 300f, 300f, 30f, 150f, false, paint)

        canvas.drawArc(dashBoardBound, (90 + ANGLE / 2).toFloat(),
                (360 - ANGLE).toFloat(), false, paint)*/
    }
}