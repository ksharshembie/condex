package com.ksharshembie.condex

import android.app.Application
import androidx.room.Room
import com.ksharshembie.condex.localData.database.Database

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(this, Database::class.java, "database").allowMainThreadQueries()
            .build()
    }

    companion object {
        lateinit var db: Database
    }
}