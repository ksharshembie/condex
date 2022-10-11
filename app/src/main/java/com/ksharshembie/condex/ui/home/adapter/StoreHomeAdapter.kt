package com.ksharshembie.condex.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ksharshembie.condex.databinding.ItemStoreHomeBinding
import com.ksharshembie.condex.localData.entity.Store

class StoreHomeAdapter : RecyclerView.Adapter<StoreHomeAdapter.StoreHomeViewHolder>() {

    private val data = arrayListOf<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHomeViewHolder {
        return StoreHomeViewHolder(
            ItemStoreHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreHomeViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addStores(list: List<Store>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    fun getStore(pos: Int): Store{
        return data[pos]
    }

    inner class StoreHomeViewHolder(private var binding: ItemStoreHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(store: Store) {
            binding.tvStoreName.text = store.name
            binding.tvStoreAddress.text = store.address
        }
    }

}