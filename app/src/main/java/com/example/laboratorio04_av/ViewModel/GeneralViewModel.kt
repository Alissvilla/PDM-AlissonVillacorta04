package com.example.laboratorio04_av.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio04_av.InitDatabase
import com.example.laboratorio04_av.Model.Task
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GeneralViewModel : ViewModel() {

    private val taskDao = InitDatabase.database.taskDao()

    val tasks: StateFlow<List<Task>> = taskDao.getAllTasks()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            val newTask = Task(
                title = title,
                description = description
            )

            taskDao.insertTask(newTask)
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }

    fun updateTaskStatus(id: Int, isComplete: Boolean) {
        viewModelScope.launch {
            taskDao.updateTaskStatus(id, isComplete)
        }
    }
}