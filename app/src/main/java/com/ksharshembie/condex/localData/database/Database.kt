package com.ksharshembie.condex.localData.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.ksharshembie.condex.localData.dao.ArticleDao
import com.ksharshembie.condex.localData.dao.StoreDao
import com.ksharshembie.condex.localData.entity.Article
import com.ksharshembie.condex.localData.entity.Store

@Database(
    entities = [Article::class, Store::class],
    version = 2,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun dao(): ArticleDao
    abstract fun daoStore(): StoreDao
}