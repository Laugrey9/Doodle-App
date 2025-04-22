package com.example.doodleapp.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawingView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private var drawPath = Path()
    private var drawPaint = Paint()
    private var canvasPaint = Paint(Paint.DITHER_FLAG)
    private var drawCanvas: Canvas? = null
    private var canvasBitmap: Bitmap? = null

    private var brushColor: Int = Color.BLACK // ✅ guardamos el color actual del pincel
    var isEraserOn = false

    init {
        setupPaint()
    }

    private fun setupPaint() {
        drawPaint.color = brushColor
        drawPaint.isAntiAlias = true
        drawPaint.strokeWidth = 10f
        drawPaint.style = Paint.Style.STROKE
        drawPaint.strokeJoin = Paint.Join.ROUND
        drawPaint.strokeCap = Paint.Cap.ROUND
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        drawCanvas = Canvas(canvasBitmap!!)
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(canvasBitmap!!, 0f, 0f, canvasPaint)
        canvas.drawPath(drawPath, drawPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val x = event.x
        val y = event.y

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                drawPath.moveTo(x, y)
            }
            MotionEvent.ACTION_MOVE -> {
                drawPath.lineTo(x, y)
                drawCanvas?.drawPath(drawPath, drawPaint)
                drawPath.reset()
                drawPath.moveTo(x, y)
            }
            MotionEvent.ACTION_UP -> {
                drawCanvas?.drawPath(drawPath, drawPaint)
                drawPath.reset()
            }
        }
        invalidate()
        return true
    }

    fun setEraser(isEraser: Boolean) {
        isEraserOn = isEraser
        if (isEraser) {
            drawPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        } else {
            drawPaint.xfermode = null
            drawPaint.color = brushColor // ✅ restauramos el último color usado
        }
    }

    fun setBrushSize(size: Float) {
        drawPaint.strokeWidth = size
    }

    fun setBrushColor(color: Int) {
        brushColor = color           // ✅ guardamos el nuevo color
        if (!isEraserOn) {
            drawPaint.color = color // Solo cambiamos si no está el borrador activo
        }
    }
}
