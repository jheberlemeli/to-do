package com.example.application.dataprovider.toDo

import com.example.application.dataprovider.toDo.exceptions.ToDoException
import com.example.application.dataprovider.toDo.repository.ToDoRepository
import com.example.application.dataprovider.toDo.repository.entity.mapper.TodoMapper
import com.example.application.dataprovider.toDo.repository.entity.mapper.TodoMapperImpl
import com.example.domain.toDo.ToDoGateway
import com.example.domain.toDo.entity.ToDo
import jakarta.inject.Singleton
import com.example.application.dataprovider.toDo.repository.entity.ToDo as ToDoApplication

@Singleton
class ToDoGatewayImpl(
    private val toDoRepository: ToDoRepository,
    private val toDoMapper: TodoMapper,
): ToDoGateway {

    override fun save(toDo: ToDo): ToDo {
        try {
            val toDoSave = toDoRepository.save(toDoMapper.toApplication(toDo))
            return toDoMapper.toDomain(toDoSave)
        }catch (ex: Exception){
            throw ToDoException(ex.cause)
        }
    }

    override fun delete(toDoId: Long) {
        try {
            toDoRepository.deleteById(toDoId)
        }catch (ex: Exception){
            throw ToDoException(ex.cause)
        }
    }

    override fun updatePartial(toDo: ToDo, changes: Map<String, String>): ToDo =
        try {
            toDoMapper.toDomain(toDoRepository.update(toDoMapper.toApplication(toDo)))
        }catch (ex: Exception){
            throw ToDoException(ex.cause)
        }


    override fun find(toDoId: Long): ToDo {
        val toDo = toDoRepository.findById(toDoId).orElseThrow { ClassNotFoundException("toDo nao encontrado") }
        return toDoMapper.toDomain(toDo)
    }
}
