package com.curiozing.kmptodoapp.articles

import com.curiozing.kmptodoapp.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class ToDoViewModel : BaseViewModel() {

    private val todoState: MutableStateFlow<MutableList<ToDo>> = MutableStateFlow(mutableListOf())

    val getToDo : StateFlow<MutableList<ToDo>> get() = todoState

    init {
        getToDoList()
    }

    private fun getToDoList() : StateFlow<MutableList<ToDo>>{
        val mockList = mutableListOf(
            ToDo(Random.nextInt(0,10),"Workout","All body exercise"),
            ToDo(Random.nextInt(0,10),"Morning task","Doing all morning tasks"),
            ToDo(Random.nextInt(0,10),"Afternoon","Doing all Afternoon tasks"),
            ToDo(Random.nextInt(0,10),"Evening task","Doing all evening tasks"))
        todoState.value.addAll(mockList)
        return getToDo
    }

    private fun addToDoList(toDo: ToDo){
        todoState.value.add(toDo)
    }

    private fun deletedToDoList(toDoId:Int) {
        val toDo = todoState.value.first {
            it.id == toDoId
        }
        todoState.value.remove(toDo)
    }

    private fun updateToDoList(index:Int, toDo: ToDo) {
        todoState.value.add(index, toDo)
    }
}



