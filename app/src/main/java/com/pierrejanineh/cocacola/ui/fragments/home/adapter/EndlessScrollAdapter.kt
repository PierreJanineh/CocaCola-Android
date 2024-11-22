package com.pierrejanineh.cocacola.ui.fragments.home.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class EndlessScrollAdapter(
    private val realAdapter: AdsAdapter
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return realAdapter.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        realAdapter.onBindViewHolder(
            holder as AdsAdapter.ViewHolder,
            position % realAdapter.itemCount
        )
    }

    override fun getItemCount(): Int = Int.MAX_VALUE
}