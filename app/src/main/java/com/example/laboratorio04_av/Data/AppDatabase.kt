package com.example.laboratorio04_av.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.laboratorio04_av.Model.Task

@Database(
    entities = [Task::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}