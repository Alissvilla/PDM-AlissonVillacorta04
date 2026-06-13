package com.example.laboratorio04_av.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val title: String,

    val description: String,

    val endDate: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "is_complete")
    val isComplete: Boolean = false
)




