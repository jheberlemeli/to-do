package com.example.domain.toDo

import com.example.domain.toDo.entity.ToDo


interface ToDoGateway {

    fun save(toDo: ToDo): ToDo

    fun delete(toDoId: Long)

    fun updatePartial(toDo: ToDo, changes: Map<String, String>): ToDo

    fun find(toDoId: Long): ToDo
}