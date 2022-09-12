package com.example.application.dataprovider.toDo

import com.example.application.dataprovider.toDo.repository.ToDoRepository
import com.example.domain.toDo.entity.ToDoProducer
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.verify
import jakarta.inject.Inject
import org.junit.jupiter.api.Test

@MicronautTest
class ToDoGatewayImplTest{
    @Inject
    lateinit var target: ToDoGatewayImpl

    @get:MockBean(ToDoRepository::class)
    val toDoRepository = mockk<ToDoRepository>()

    @Test
    fun `given toDo should save it`(){
        every { toDoRepository.save(any()) } returns ToDoProducer().buildApplication()
        target.save(ToDoProducer().build())

        verify { toDoRepository.save(any()) }
    }
}