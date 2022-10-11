package com.ksharshembie.condex.localData.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ksharshembie.condex.localData.entity.Store

@Dao
interface StoreDao {

    @Insert
    fun insert (store: Store)

    @Delete
    fun delete (store: Store)

    @Query("Select * from store")
    fun getAllStore(): List<Store>

}