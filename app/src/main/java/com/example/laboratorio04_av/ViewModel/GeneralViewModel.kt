package com.example.laboratorio04_av.ViewModel

import androidx.lifecycle.ViewModel
import com.example.laboratorio04_av.Model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralViewModel : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()

    fun addTask(title: String, description: String) {
        val newTask = Task(
            id = _tasks.value.size + 1,
            title = title,
            description = description
        )

        _tasks.value = _tasks.value + newTask
    }
}