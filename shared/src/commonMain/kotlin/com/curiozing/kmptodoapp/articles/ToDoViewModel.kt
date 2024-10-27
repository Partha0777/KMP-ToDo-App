package com.curiozing.kmptodoapp.articles

import com.curiozing.kmptodoapp.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class ToDoViewModel : BaseViewModel() {

    private val todoState: MutableStateFlow<MutableList<ToDo>> = MutableStateFlow(mutableListOf())

    var getToDo: StateFlow<MutableList<ToDo>> = todoState

    init {
        getToDoList()
    }

    private fun getToDoList(): StateFlow<MutableList<ToDo>> {
        val mockList = mutableListOf(
            ToDo(Random.nextInt(0, 10), "Workout", "All body exercise"),
            ToDo(Random.nextInt(0, 10), "Morning task", "Doing all morning tasks"),
            ToDo(Random.nextInt(0, 10), "Afternoon", "Doing all Afternoon tasks"),
            ToDo(Random.nextInt(0, 10), "Evening task", "Doing all evening tasks")
        )
        todoState.value.addAll(mockList)
        return getToDo
    }

    fun addToDoList(toDo: ToDo) {
        todoState.value = (todoState.value + toDo).toMutableList()
    }

    private fun deletedToDoList(toDoId: Int) {
        val toDo = todoState.value.first {
            it.id == toDoId
        }
        todoState.value.remove(toDo)
        todoState.value = todoState.value
    }

    private fun updateToDoList(index: Int, toDo: ToDo) {
        todoState.value.add(index, toDo)
        todoState.value = todoState.value
    }
}



