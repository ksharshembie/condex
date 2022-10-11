package com.ksharshembie.condex.localData.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Store(
    @PrimaryKey(autoGenerate = true)
    var idStore: Long? = null,
    var name: String,
    var code: String,
    var address: String
) : Serializable
