package com.example.laboratorio04_av

import android.app.Application
import androidx.room.Room
import com.example.laboratorio04_av.Data.AppDatabase

class InitDatabase : Application() {

    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "task_database"
        )
            .fallbackToDestructiveMigration(true)
            .build()
    }
}