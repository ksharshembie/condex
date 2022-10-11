package com.ksharshembie.condex.ui.profile.store.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ksharshembie.condex.databinding.ItemStoreBinding
import com.ksharshembie.condex.localData.entity.Store

class StoreAdapter(private val onLongClick: (Int) -> Unit) : RecyclerView.Adapter<StoreAdapter.StoreViewHolder>() {
    private val data = arrayListOf<Store>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            ItemStoreBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
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

    inner class StoreViewHolder(private var binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(store: Store) {
            binding.tvStoreName.text = store.name
            binding.tvStoreAddress.text = store.address
            itemView.setOnLongClickListener {
                onLongClick(adapterPosition)
                false
            }
        }
    }
}