package com.example.domain.toDo

import com.example.domain.toDo.entity.ToDo

interface ToDoGateway {

    fun save(toDo: ToDo)

    fun delete(toDoId: Long)

    fun update(toDo: ToDo)

    fun find(toDoId: Long?)
}