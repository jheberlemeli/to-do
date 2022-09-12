package com.example.application.dataprovider.toDo.repository.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
data class ToDo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val desc: String
) {
}