package com.ksharshembie.condex.ui.home.article.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ksharshembie.condex.databinding.ItemArticleBinding
import com.ksharshembie.condex.localData.entity.Article

class ArticleAdapter : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private val data = arrayListOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addArticle(article: Article) {
        data.add(0,article)
        notifyItemChanged(0)
    }

    fun addArticles(list: List<Article>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    inner class ArticleViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.tvArticleName.text = article.name
            binding.tvArticleVendorCode.text = article.vendorCode
        }

    }
}