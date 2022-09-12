package com.example.application.dataprovider.toDo.repository
import io.micronaut.core.io.ResourceLoader
import com.example.application.dataprovider.toDo.repository.entity.ToDo as ToDoApplication


data class ToDoDBProducer(
    val resourceLoader: ResourceLoader,
    val id: Long = 1,
    val title: String = "list",
    val desc: String = "list to do"
) {

    fun build() =
        com.example.application.dataprovider.toDo.repository.entity.ToDo(id, title, desc)

    fun buildApplication() =
        ToDoApplication(id,title, desc)
}