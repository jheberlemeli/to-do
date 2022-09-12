package com.example.application.dataprovider.toDo.repository.entity.mapper

import com.example.application.dataprovider.toDo.repository.entity.ToDo as ToDoApplication
import com.example.domain.toDo.entity.ToDo
import org.mapstruct.Mapper

@Mapper
interface TodoMapper {

    fun toApplication(toDo: ToDo): ToDoApplication
}