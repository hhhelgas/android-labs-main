package com.example.alexklim_17

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View

class Draw2D(context: Context?) : View(context) {
    private val paint: Paint = Paint()
    private val rect: Rect = Rect()
    private var bitmap = BitmapFactory.decodeResource(resources, R.drawable.lake)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        paint.apply {
            style = Paint.Style.FILL
            color = Color.BLUE
        }
        canvas.drawPaint(paint)

        paint.color = Color.GREEN
        canvas.drawRect(0F, 10000F, 10000F, 2400F, paint)

        paint.apply {
            isAntiAlias = true
            color = Color.YELLOW
        }
        canvas.drawCircle(950F, 1200F, 250F, paint)

        paint.apply {
            color = Color.CYAN
            style = Paint.Style.FILL
            isAntiAlias = true
            textSize = 96F
        }
        canvas.drawText(resources.getString(R.string.my), 280F, 2300F, paint)

        paint.apply {
            color = Color.GRAY
            style = Paint.Style.FILL
            textSize = 64F
        }

        canvas.save()
        canvas.rotate(-67F, 545 + rect.exactCenterX(), 1800 + rect.exactCenterY())
        canvas.drawText(resources.getString(R.string.sun), 545F, 1800F, paint)

        canvas.restore()

        canvas.drawBitmap(bitmap, 500F, 2350F, paint)
    }
}