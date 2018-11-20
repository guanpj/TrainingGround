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

    internal var topFlip = 0f
    internal var bottomFlip = 0f
    internal var flipRotation = 0f

    init {
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
        canvas.rotate(flipRotation)
        camera.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-bitmapWidth, -bitmapHeight, bitmapWidth, 0f)
        canvas.rotate(-flipRotation)
        canvas.translate(-centerX, -centerY)
        canvas.drawBitmap(bitmap, bitmapLeft, bitmapTop, paint)
        canvas.restore()

        canvas.save()
        canvas.translate(centerX, centerY)
        canvas.rotate(flipRotation)
        camera.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-bitmapWidth, 0f, bitmapWidth, bitmapHeight)
        canvas.rotate(-flipRotation)
        canvas.translate(-centerX, -centerY)
        canvas.drawBitmap(bitmap, bitmapLeft, bitmapTop, paint)
        canvas.restore()
    }

    fun getTopFlip(): Float {
        return topFlip
    }

    fun setTopFlip(topFlip: Float) {
        this.topFlip = topFlip
        invalidate()
    }

    fun getBottomFlip(): Float {
        return bottomFlip
    }

    fun setBottomFlip(bottomFlip: Float) {
        this.bottomFlip = bottomFlip
        invalidate()
    }

    fun getFlipRotation(): Float {
        return flipRotation
    }

    fun setFlipRotation(flipRotation: Float) {
        this.flipRotation = flipRotation
        invalidate()
    }

    fun reset() {
        topFlip = 0f
        bottomFlip = 0f
        flipRotation = 0f
    }
}