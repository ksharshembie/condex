package com.ksharshembie.condex.ui.home.article

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.ksharshembie.condex.App
import com.ksharshembie.condex.R
import com.ksharshembie.condex.databinding.FragmentArticleAddBinding
import com.ksharshembie.condex.databinding.FragmentArticleBinding
import com.ksharshembie.condex.localData.entity.Article
import com.ksharshembie.condex.ui.home.article.adapter.ArticleAdapter

class ArticleFragment : Fragment() {
    private lateinit var binding: FragmentArticleBinding
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ArticleAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.articleAddFragment)
        }
        val list = App.db.dao().getAllArticle()
        binding.articleRecyclerView.adapter = adapter
        adapter.addArticles(list)
    }

}