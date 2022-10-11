package com.ksharshembie.condex.ui.profile.store

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ksharshembie.condex.App
import com.ksharshembie.condex.R
import com.ksharshembie.condex.databinding.FragmentStoreAddBinding
import com.ksharshembie.condex.localData.entity.Store

class StoreAddFragment : Fragment() {

    private lateinit var binding: FragmentStoreAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentStoreAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSave.setOnClickListener {
            if (TextUtils.isEmpty(binding.etStoreName.text)||binding.etStoreName.text.toString().contains(" ")){
                binding.etStoreName.setError(getString(R.string.please_fill_store_name))
            }
            else{
            App.db.daoStore().insert(
                Store(
                    name = binding.etStoreName.text.toString(),
                    code = binding.etStoreCode.text.toString(),
                    address = binding.etStoreAddress.text.toString()
                )
            )}
            findNavController().navigateUp()
        }

        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}