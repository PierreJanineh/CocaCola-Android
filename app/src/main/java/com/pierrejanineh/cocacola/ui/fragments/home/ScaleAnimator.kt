package com.pierrejanineh.cocacola.ui.fragments.home

import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView

class ScaleCardAnimator : RecyclerView.OnScrollListener() {

    private companion object {
        const val MAX_SCALE = 1f
        const val MIN_SCALE = 0.96f
        const val SCALE_DIFFERENCE = MAX_SCALE - MIN_SCALE
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        val centerX = recyclerView.width / 2f

        recyclerView.children.forEach { child ->
            val childCenterX = child.centerX
            val scrollState = ScrollState.from(dx, childCenterX, centerX.toInt())
            val progress = scrollState.calculateProgress(childCenterX.toFloat(), centerX)
            val scale = MIN_SCALE + (SCALE_DIFFERENCE * progress)

            child.applyScale(scale)
        }
    }

    private enum class ScrollState(
        val calculateProgress: (childCenterX: Float, centerX: Float) -> Float
    ) {
        MOVING_RIGHT_FROM_LEFT(
            { childCenter, center -> (childCenter / center).coerceIn(0f, 1f) }
        ),
        MOVING_RIGHT_FROM_RIGHT(
            { childCenter, center -> 1f - (childCenter - center) / center }
        ),
        MOVING_LEFT_FROM_RIGHT(
            { childCenter, center -> 1f - (childCenter - center) / center }
        ),
        MOVING_LEFT_FROM_LEFT(
            { childCenter, center -> childCenter / center }
        );

        companion object {
            fun from(dx: Int, childCenterX: Int, centerX: Int) = when {
                dx > 0 && childCenterX < centerX -> MOVING_RIGHT_FROM_LEFT
                dx > 0 && childCenterX >= centerX -> MOVING_RIGHT_FROM_RIGHT
                dx < 0 && childCenterX > centerX -> MOVING_LEFT_FROM_RIGHT
                //dx < 0 && childCenterX <= centerX
                else -> MOVING_LEFT_FROM_LEFT
            }
        }
    }

    private val View.centerX: Int
        get() = (left + right) / 2

    private fun View.applyScale(scale: Float) {
        scaleX = scale
        scaleY = scale
    }
}