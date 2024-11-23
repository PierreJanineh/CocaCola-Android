package com.pierrejanineh.cocacola.ui.fragments.home.adapter

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.pierrejanineh.cocacola.ui.fragments.home.animation.ScaleCardAnimator

class EndlessScrollAdapter(
    private val realAdapter: AdsAdapter
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        realAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            @SuppressLint("NotifyDataSetChanged")
            override fun onChanged() {
                notifyDataSetChanged()
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return realAdapter.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val originalPosition = position % realAdapter.itemCount
        realAdapter.onBindViewHolder(holder as AdsAdapter.ViewHolder, originalPosition)
    }

    override fun getItemCount(): Int = realAdapter.itemCount * 2

    fun attachToRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = this

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val originalCount = realAdapter.itemCount

                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as? LinearLayoutManager ?: return
                val firstVisible = layoutManager.findFirstVisibleItemPosition()
                val lastVisible = layoutManager.findLastVisibleItemPosition()

                when {
                    lastVisible >= itemCount - (originalCount / 2) -> {
                        val targetPosition = firstVisible - originalCount
                        layoutManager.scrollToPositionWithOffset(targetPosition, 0)
                    }
                }
            }
        })
    }
}

fun RecyclerView.setupEndlessScroll(realAdapter: AdsAdapter) {
    val endlessAdapter = EndlessScrollAdapter(realAdapter)
    endlessAdapter.attachToRecyclerView(this)
}