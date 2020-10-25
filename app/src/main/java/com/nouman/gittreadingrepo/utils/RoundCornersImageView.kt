package com.nouman.gittreadingrepo.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.nouman.gittreadingrepo.R

class RoundCornersImageView (context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {

    private val radius: Float by lazy {
        context.resources.getDimension(R.dimen.corners_radius)
    }

    override fun onDraw(canvas: Canvas?) {
        val path = getPath(radius, true, true, true, true)
        canvas!!.clipPath(path!!)
        super.onDraw(canvas)
    }

    private fun getPath(
        radius: Float, topLeft: Boolean, topRight: Boolean,
        bottomRight: Boolean, bottomLeft: Boolean
    ): Path? {
        val path = Path()
        val radii = FloatArray(8)
        if (topLeft) {
            radii[0] = radius
            radii[1] = radius
        }
        if (topRight) {
            radii[2] = radius
            radii[3] = radius
        }
        if (bottomRight) {
            radii[4] = radius
            radii[5] = radius
        }
        if (bottomLeft) {
            radii[6] = radius
            radii[7] = radius
        }
        path.addRoundRect(
            RectF(0f, 0f, width.toFloat(), height.toFloat()),
            radii, Path.Direction.CW
        )
        return path
    }

}