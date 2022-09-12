package com.example.domain.toDo.entity
import com.example.application.dataprovider.toDo.repository.entity.ToDo as ToDoApplication


data class ToDoProducer(
    val id: Long = 1,
    val title: String = "list",
    val desc: String = "list to do"
) {

    fun build() =
        ToDo(id, title, desc)

    fun buildApplication() =
        ToDoApplication(id,title, desc)
}