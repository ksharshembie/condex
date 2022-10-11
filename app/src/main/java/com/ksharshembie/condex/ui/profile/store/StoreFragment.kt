package com.ksharshembie.condex.ui.profile.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ksharshembie.condex.App
import com.ksharshembie.condex.R
import com.ksharshembie.condex.databinding.FragmentStoreBinding
import com.ksharshembie.condex.ui.profile.store.adapter.StoreAdapter


class StoreFragment : Fragment() {

    private lateinit var binding: FragmentStoreBinding
    private lateinit var adapter: StoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = StoreAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.storeAddFragment)
        }
        binding.storeRecyclerView.adapter = adapter
        setStoreData()
    }

    fun setStoreData() {
        val list = App.db.daoStore().getAllStore()
        adapter.addStores(list)
    }
}