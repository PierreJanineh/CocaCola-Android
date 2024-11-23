package com.pierrejanineh.cocacola.ui.fragments.home.animation

import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

class ScaleCardAnimator : RecyclerView.OnScrollListener() {

    companion object {
        private const val MAX_SCALE = 1f
        private const val MIN_SCALE = 0.9f
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val centerX = recyclerView.width / 2f

        recyclerView.children.forEach { child ->
            val childCenterX = (child.left + child.right) / 2f
            val distanceFromCenter = abs(childCenterX - centerX)

            // Calculate scale based on distance from center
            val scale = MAX_SCALE - (distanceFromCenter / recyclerView.width) * (MAX_SCALE - MIN_SCALE)

            // Apply the scale, constrained between MIN_SCALE and MAX_SCALE
            child.scaleX = scale.coerceIn(MIN_SCALE, MAX_SCALE)
            child.scaleY = scale.coerceIn(MIN_SCALE, MAX_SCALE)
        }
    }
}