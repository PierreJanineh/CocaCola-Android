package com.pierrejanineh.cocacola.ui.fragments.home.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pierrejanineh.cocacola.databinding.CardSingleAdBinding
import com.pierrejanineh.cocacola.data.model.SingleAd

class AdsAdapter(private val context: Context) : RecyclerView.Adapter<AdsAdapter.ViewHolder>() {

    private var items = listOf<SingleAd>()
    private var onItemClickListener: ((SingleAd) -> Unit)? = null
    private var parentHeight: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardSingleAdBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        parentHeight = parent.measuredHeightAndState
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        val displayMetrics = context.resources.displayMetrics
        val screenHeight = displayMetrics.heightPixels

        holder.binding.root.layoutParams = RecyclerView.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            (screenHeight * 0.6).toInt()
        )
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: List<SingleAd>) {
        items = newItems
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: CardSingleAdBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SingleAd) {
            binding.apply {
                title.text = item.title
                heading.text = item.heading

                Glide.with(itemView)
                    .load(item.imageUrl)
                    .into(image)

                root.setOnClickListener {
                    onItemClickListener?.invoke(item)
                }
            }
        }
    }
}