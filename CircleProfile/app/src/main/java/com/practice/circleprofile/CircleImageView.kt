package com.practice.circleprofile

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet

private const val TAG = "CircleImageView"


class CircleImageView : androidx.appcompat.widget.AppCompatImageView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(
        context,
        attrs
    ) // LayoutInflater에 사용되는 생성자

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private var radius = 200.0f // 값이 클수록 더욱 둥글게 됩니다.

    fun setRadius(radius: Float) {
        this.radius = radius
    }

    override fun onDraw(canvas: Canvas?) {

        val path = Path()

        val rect = RectF(0f, 0f, this.width.toFloat(), this.height.toFloat())

        /*clipPath.addCircle(
            this.width.toFloat() / 2,
            this.height.toFloat() / 2,
            50f,
            Path.Direction.CW
        )*/
        path.addRoundRect(rect, radius, radius, Path.Direction.CW)

        canvas!!.clipPath(path)
        super.onDraw(canvas)
    }

}