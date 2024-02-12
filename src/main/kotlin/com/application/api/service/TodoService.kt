package com.application.api.service

import com.application.api.data.Todo
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo service")
class TodoService{

    fun getTodos(): List<Todo> = listOf(
        Todo(
            UUID.randomUUID().toString(),
            "My first todo",
            "this is a message from my first todo",
            System.currentTimeMillis().toString()
        ),
        Todo(
            UUID.randomUUID().toString(),
            "My second Todo",
            "this is a message from my second todo",
            System.currentTimeMillis().toString()
        )
    )

    fun insertTodo(todo: Todo): Todo{
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    fun deleteTodo(id: String): Boolean = false

    fun updateTodo(todo: Todo): Boolean = true
}