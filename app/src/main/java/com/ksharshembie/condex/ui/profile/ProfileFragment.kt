package com.ksharshembie.condex.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ksharshembie.condex.R
import com.ksharshembie.condex.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivProfile.setOnClickListener {
            imagePickup.launch("image/*")
        }

        binding.menuArticle.setOnClickListener {
            findNavController().navigate(R.id.articleFragment)
        }
        binding.menuStore.setOnClickListener {
            findNavController().navigate(R.id.storeFragment)
        }
    }

    private val imagePickup = registerForActivityResult(ActivityResultContracts.GetContent(),
        ActivityResultCallback {
            binding.ivProfile.setImageURI(it)
        })

}