package com.example.domain.toDo

import com.example.application.dataprovider.toDo.repository.entity.ToDo


interface ToDoGateway {

    fun save(toDo: ToDo): ToDo

    fun delete(toDoId: Long)

    fun updatePartial(toDoId: Long, changes: Map<String, String>): ToDo

    fun find(toDoId: Long): ToDo
}