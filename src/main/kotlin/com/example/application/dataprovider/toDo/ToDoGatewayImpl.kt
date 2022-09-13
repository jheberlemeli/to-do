package com.example.application.dataprovider.toDo

import com.example.application.dataprovider.toDo.exceptions.ToDoException
import com.example.application.dataprovider.toDo.repository.ToDoRepository
import com.example.domain.toDo.ToDoGateway
import jakarta.inject.Singleton
import com.example.application.dataprovider.toDo.repository.entity.ToDo as ToDoApplication

@Singleton
class ToDoGatewayImpl(
    private val toDoRepository: ToDoRepository,
): ToDoGateway {

    override fun save(toDo: ToDoApplication): ToDoApplication {
        try {
            val toDoSave = toDoRepository.save(toDo)
            return toDoSave
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

    override fun updatePartial(toDoId: Long, changes: Map<String, String>): ToDoApplication {
        try {
            val toDoIdEntity = find(toDoId)

            changes.forEach { atributo, valor ->
                when (atributo) {
                    "title" ->  toDoIdEntity.title = valor
                    "desc" -> toDoIdEntity.desc = valor
                }
            }
            return save(toDoIdEntity)
        }catch (ex: Exception){
            throw ToDoException(ex.cause)
        }

    }

    override fun find(toDoId: Long): ToDoApplication {
        return toDoRepository.findById(toDoId).orElseThrow { ClassNotFoundException("toDo nao encontrado") }
    }
}
