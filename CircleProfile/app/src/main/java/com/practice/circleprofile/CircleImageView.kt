package com.practice.circleprofile

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import kotlin.math.min

private const val TAG = "CircleImageView"


class CircleImageView : androidx.appcompat.widget.AppCompatImageView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(
        context,
        attrs
    ) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    private var radius = 0.0f

    private fun init() {
        setScaleType()
    }

    private fun setScaleType() {
        super.setScaleType(ScaleType.CENTER_CROP)
    }

    override fun onDraw(canvas: Canvas?) {
        val path = Path()

        val rect = RectF(0f, 0f, this.width.toFloat(), this.height.toFloat())
        radius = min(this.width.toFloat() / 2.0f, this.height.toFloat() / 2.0f)
        path.addRoundRect(rect, radius, radius, Path.Direction.CW)
        canvas!!.clipPath(path)
        super.onDraw(canvas)

    }

}