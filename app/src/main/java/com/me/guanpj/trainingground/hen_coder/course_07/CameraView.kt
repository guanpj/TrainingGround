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
        bitmap = Utils.getAvatar(resources, 600)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val bitmapWidth = bitmap.width.toFloat()
        val bitmapHeight = bitmap.height.toFloat()
        val centerX = width / 2f
        val centerY = height / 2f
        val bitmapLeft = centerX - bitmapWidth / 2
        val bitmapTop = centerY - bitmapHeight / 2
        val bitmapRight = centerX + bitmapHeight / 2
        val bitmapBottom = centerY + bitmapHeight / 2

        canvas.save()
        canvas.translate(centerX, centerY)
        //canvas.rotate(20f)
        canvas.clipRect(-bitmapWidth, -bitmapHeight, bitmapWidth, 0f)
        //canvas.rotate(-20f)
        canvas.translate(-centerX, -centerY)
        canvas.drawBitmap(bitmap, bitmapLeft, bitmapTop, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(centerX, centerY)
        //canvas.rotate(20f)
        camera.applyToCanvas(canvas)
        canvas.clipRect(-bitmapWidth, 0f, bitmapWidth, bitmapHeight)
        //canvas.rotate(-20f)
        canvas.translate(-centerX, -centerY)
        canvas.drawBitmap(bitmap, bitmapLeft, bitmapTop, paint)
        canvas.restore()

    }
}