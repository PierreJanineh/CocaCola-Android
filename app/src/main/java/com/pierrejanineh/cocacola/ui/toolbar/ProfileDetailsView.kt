package com.pierrejanineh.cocacola.ui.toolbar

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.pierrejanineh.cocacola.R
import com.pierrejanineh.cocacola.databinding.ViewProfileDetailsBinding

class ProfileDetailsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding: ViewProfileDetailsBinding? = null
    private var onProfileClickListener: (() -> Unit)? = null

    init {
        setupView()
        setupAttributes(attrs)
    }

    private fun setupView() {
        orientation = VERTICAL

        binding = ViewProfileDetailsBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

        setOnClickListener {
            onProfileClickListener?.invoke()
        }
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.ProfileDetailsView,
            0, 0
        ).apply {
            try {
                binding?.apply {
                    lidsCount.text = getString(R.styleable.ProfileDetailsView_lidsCount)
                    angelsCount.text = getString(R.styleable.ProfileDetailsView_angelsCount)
                }
            } finally {
                recycle()
            }
        }
    }

    fun setLidsAndAngelsCount(lids: Int, angels: Int) {
        binding?.apply {
            lidsCount.text = lids.toString()
            angelsCount.text = angels.toString()
        }
    }

    fun setOnProfileClickListener(listener: () -> Unit) {
        onProfileClickListener = listener
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        binding = null
    }
}