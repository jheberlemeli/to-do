package com.example.application.dataprovider.toDo.exceptions

class ToDoException(
    cause: Throwable?
): RuntimeException("Something went wrong", cause)