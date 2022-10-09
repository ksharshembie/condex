package com.ksharshembie.condex.ui.home.article

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.ksharshembie.condex.App
import com.ksharshembie.condex.R
import com.ksharshembie.condex.databinding.FragmentArticleAddBinding
import com.ksharshembie.condex.localData.entity.Article

class ArticleAddFragment : Fragment() {

    private lateinit var binding: FragmentArticleAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticleAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCancel.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnSave.setOnClickListener {
            if (TextUtils.isEmpty(binding.etArticleName.text) || binding.etArticleName.text.toString().contains(" ")) {
                binding.etArticleName.setError(getString(R.string.please_fill_article_code))
            } else if (TextUtils.isEmpty(binding.etArticleVendorCode.text)) {
                binding.etArticleVendorCode.setError(getString(R.string.please_fill_article_vendor_code))
            } else {
                App.db.dao().insert(
                    Article(
                        name = binding.etArticleName.text.toString(),
                        vendorCode = binding.etArticleVendorCode.text.toString()
                    )
                )
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        const val FRAGMENT_RESULT = "af_result"
        const val ARTICLE_KEY = "article"
    }

}