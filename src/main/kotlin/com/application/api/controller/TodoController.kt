package com.application.api.controller

import TodoService
import com.application.api.data.Todo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.print.attribute.standard.Media

@RestController
@RequestMapping("/todos")
class TodoController {

    @Autowired
    private lateinit var service: TodoService
    /**
     * Get ToDos.
     */
    @GetMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodDos():List<Todo> = service.getTodos()

    /**
     * Insert Item.
     * It consumes JSON, that is: request Body todo.
     */
    @PostMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
                    consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun insertTodo(@RequestBody todo: Todo): Todo = service.insertTodo(todo)

    /**
     * Remove item by Id
     * We introduced path variable for ID to pass
     */
    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean = service.deleteTodo(id)

    /**
     * Update Item.
     * It consumes JSON, that is: request body Todo.
     * As result it returns updated Todo.
     */
    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(@RequestBody todo: Todo): Boolean = service.updateTodo(todo)
}