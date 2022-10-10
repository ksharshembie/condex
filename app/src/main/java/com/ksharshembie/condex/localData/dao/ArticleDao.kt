package com.ksharshembie.condex.localData.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ksharshembie.condex.localData.entity.Article

@Dao
interface ArticleDao {

    @Insert
    fun insert(article: Article)

    @Delete
    fun delete(article: Article)

    @Query("SELECT * FROM article order by name")
    fun getAllArticle(): List<Article>
}