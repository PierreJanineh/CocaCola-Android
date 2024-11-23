package com.pierrejanineh.cocacola.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.pierrejanineh.cocacola.databinding.FragmentHomeBinding
import com.pierrejanineh.cocacola.data.repository.AdRepository
import com.pierrejanineh.cocacola.ui.fragments.home.adapter.AdsAdapter
import com.pierrejanineh.cocacola.ui.fragments.home.adapter.EndlessScrollAdapter
import com.pierrejanineh.cocacola.ui.fragments.home.adapter.setupEndlessScroll
import com.pierrejanineh.cocacola.ui.fragments.home.animation.ScaleCardAnimator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adsAdapter: AdsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdsRecyclerView()
        loadItems()
    }

    private fun setupAdsRecyclerView() {
        adsAdapter = AdsAdapter(requireContext())

        binding.adsRecyclerView.apply {
            setupEndlessScroll(adsAdapter)

            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )

            PagerSnapHelper().attachToRecyclerView(this)

            addOnScrollListener(ScaleCardAnimator())
        }
    }

    private fun loadItems() {
        adsAdapter.setItems(AdRepository().getAds())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}