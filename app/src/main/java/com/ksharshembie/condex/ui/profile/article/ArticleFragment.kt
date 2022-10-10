package com.ksharshembie.condex.ui.profile.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ksharshembie.condex.App
import com.ksharshembie.condex.R
import com.ksharshembie.condex.databinding.FragmentArticleBinding
import com.ksharshembie.condex.ui.profile.article.adapter.ArticleAdapter

class ArticleFragment : Fragment() {
    private lateinit var binding: FragmentArticleBinding
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ArticleAdapter(){ pos ->
            val alertDialog = AlertDialog.Builder(requireContext())
            alertDialog.setTitle(getString(R.string.delete))
            alertDialog.setPositiveButton(getString(R.string.yes)){ dialog, _ ->
                App.db.dao().delete(adapter.getArticle(pos))
                setArticleData()
                dialog.dismiss()
            }
            alertDialog.setNegativeButton(getString(R.string.no)){ dialog, _ ->
                dialog.dismiss()
            }
            alertDialog.create().show()
        }
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

        binding.articleRecyclerView.adapter = adapter
        setArticleData()
    }

    fun setArticleData(){
        val list = App.db.dao().getAllArticle()
        adapter.addArticles(list)
    }

}