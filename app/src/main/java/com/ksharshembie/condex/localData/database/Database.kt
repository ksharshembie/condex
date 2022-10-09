package com.ksharshembie.condex.localData.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ksharshembie.condex.localData.dao.ArticleDao
import com.ksharshembie.condex.localData.entity.Article

@Database(entities = [Article::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun dao(): ArticleDao
}