package com.ksharshembie.condex.localData.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var name: String,
    var vendorCode: String
) : Serializable