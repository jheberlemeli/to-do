package com.example.application.dataprovider.toDo.repository

import com.example.application.dataprovider.toDo.repository.entity.ToDo
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface ToDoRepository: JpaRepository<ToDo, Long> {
}