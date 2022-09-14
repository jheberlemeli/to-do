package com.example.application.entrypoint

import com.example.domain.toDo.ToDoGateway
import com.example.domain.toDo.entity.ToDo
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

    @Patch
    fun updatePartial(toDo: ToDo, changes: Map<String, String>): ToDo{
        return toDoGateway.updatePartial(toDo, changes)
    }

}