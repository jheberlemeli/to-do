package com.example.application.entrypoint

import com.example.application.dataprovider.toDo.repository.entity.ToDo
import com.example.domain.toDo.ToDoGateway
import io.micronaut.http.annotation.*

@Controller("/toDo")
class ToDoEntryPoint(
    val toDoGateway: ToDoGateway
) {

    @Get("/{toDoId}")
    fun get(toDoId: Long): ToDo{
        return toDoGateway.find(toDoId)
    }

    @Post
    fun create(toDo: ToDo): ToDo{
        return toDoGateway.save(toDo)
    }

    @Delete("/{toDoId}")
    fun delete(toDoId: Long){
        toDoGateway.delete(toDoId)
    }

    @Patch("/{toDoId}")
    fun updatePartial(toDoId: Long, changes: Map<String, String>): ToDo{
        return toDoGateway.updatePartial(toDoId, changes)
    }

}