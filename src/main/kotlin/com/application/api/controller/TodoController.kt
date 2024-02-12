package com.application.api.controller

import com.application.api.data.Todo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.print.attribute.standard.Media

@RestController
@RequestMapping("/todos")
class TodoController {
    /**
     * Get ToDos.
     */
    @GetMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodDos():List<Todo>{
        return listOf(
            Todo(
                UUID.randomUUID().toString(),
                "My first ToDo",
                "This a message for my first todo",
                System.currentTimeMillis().toString()
            ),
            Todo(
                UUID.randomUUID().toString(),
                "My second todo",
                "Message for my second todo",
                System.currentTimeMillis().toString()
            )
        )
    }

    /**
     * Insert Item.
     * It consumes JSON, that is: request Body todo.
     */
    @PostMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
                    consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun insertTodo(@RequestBody todo: Todo): Todo{
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    /**
     * Remove item by Id
     * We introduced path variable for ID to pass
     */
    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean{
        println("Removing $id")
        return true
    }

    /**
     * Update Item.
     * It consumes JSON, that is: request body Todo.
     * As result it returns updated Todo.
     */
    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(@RequestBody todo: Todo): Todo {
        todo.title += " [updated] "
        todo.message += " [updated] "
        todo.schedule = System.currentTimeMillis().toString()
        return todo
    }
}