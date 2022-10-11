package com.ksharshembie.condex.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.ksharshembie.condex.App
import com.ksharshembie.condex.R
import com.ksharshembie.condex.databinding.FragmentCustomerBinding
import com.ksharshembie.condex.databinding.FragmentHomeBinding
import com.ksharshembie.condex.ui.customer.CustomerFragment
import com.ksharshembie.condex.ui.home.adapter.StoreHomeAdapter
import com.ksharshembie.condex.ui.profile.store.adapter.StoreAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: StoreHomeAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = StoreHomeAdapter()
    }

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

        val pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(binding.storesRecyclerView)

        binding.storesRecyclerView.adapter = adapter
        val list = App.db.daoStore().getAllStore()
        adapter.addStores(list)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}