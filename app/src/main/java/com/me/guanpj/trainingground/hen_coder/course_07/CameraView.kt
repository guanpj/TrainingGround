package com.me.guanpj.trainingground.hen_coder.course_07

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.me.guanpj.trainingground.Utils

class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var camera = Camera()
    private lateinit var bitmap: Bitmap

    init {
        camera.rotateX(45f)
        camera.setLocation(0f, 0f, Utils.getZForCamera())
        bitmap = Utils.getAvatar(resources, 400)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmapWidth = bitmap.width
        val bitmapHeight = bitmap.height
        val centerX = width / 2f
        val centerY = height / 2f
        val x = centerX - bitmapWidth / 2
        val y = centerY - bitmapHeight / 2

        canvas.translate(centerX, centerY)
        camera.applyToCanvas(canvas)
        canvas.translate(-centerX, -centerY)
        canvas.drawBitmap(bitmap, x, y, paint)

    }
}