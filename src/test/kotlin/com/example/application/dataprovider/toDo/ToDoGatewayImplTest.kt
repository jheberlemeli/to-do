package com.example.application.dataprovider.toDo

import com.example.application.dataprovider.toDo.repository.ToDoDBProducer
import com.example.application.dataprovider.toDo.repository.ToDoRepository
import com.example.domain.toDo.entity.ToDoProducer
import io.micronaut.core.io.ResourceLoader
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import jakarta.inject.Inject
import org.junit.jupiter.api.Test
import java.util.*

@MicronautTest
class ToDoGatewayImplTest{
    @Inject
    lateinit var target: ToDoGatewayImpl

    @get:MockBean(ToDoRepository::class)
    val toDoRepository = mockk<ToDoRepository>()

    @Inject
    lateinit var resourceLoader: ResourceLoader

    @Test
    fun `given toDo should save it`(){
        every { toDoRepository.save(any()) } returns ToDoProducer().buildApplication()
        target.save(ToDoProducer().build())

        verify { toDoRepository.save(any()) }
    }

    @Test
    fun `given toDo should findById it`(){
        val toDo = ToDoProducer().build()

        val toDoDBProducer = ToDoDBProducer(
            resourceLoader = resourceLoader
        ).build()

        val toDoId = toDo.id

        every { toDoRepository.findById(eq(toDoId)) } returns Optional.of(toDoDBProducer)
        target.find(toDoId)

        verify { toDoRepository.findById(eq(toDoId)) }
    }


}