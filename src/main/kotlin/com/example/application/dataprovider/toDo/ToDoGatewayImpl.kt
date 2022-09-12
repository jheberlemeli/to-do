package com.example.application.dataprovider.toDo

import com.example.application.dataprovider.toDo.exceptions.ToDoException
import com.example.application.dataprovider.toDo.repository.ToDoRepository
import com.example.application.dataprovider.toDo.repository.entity.mapper.TodoMapper
import com.example.domain.toDo.ToDoGateway
import com.example.domain.toDo.entity.ToDo
import jakarta.inject.Singleton

@Singleton
class ToDoGatewayImpl(
    private val toDoRepository: ToDoRepository,
    private val todoMapper: TodoMapper
): ToDoGateway {

    override fun save(toDo: ToDo) {
        try {
            toDoRepository.save(todoMapper.toApplication(toDo))
        }catch (ex: Exception){
            throw ToDoException(ex.cause)
        }
    }

    override fun delete(toDoId: Long) {
    }

    override fun update(toDo: ToDo) {
    }

    override fun find(toDoId: Long?) {
    }
}