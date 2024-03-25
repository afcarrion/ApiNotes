package com.application.api.controller

import com.application.api.data.Todo
import com.application.api.data.TodoDTO
import com.application.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

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
    fun getTodDos():Iterable<TodoDTO> = service.getTodos()

    /**
     * Insert Item.
     * It consumes JSON, that is: request Body todo.
     */
    @PostMapping(produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
                    consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun insertTodo(@RequestBody todo: TodoDTO): TodoDTO = service.insertTodo(todo)

    /**
     * Remove item by Id
     * We introduced path variable for ID to pass
     */
    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteTodo(@PathVariable(name = "id") id: String) = service.deleteTodo(id)

    /**
     * Update Item.
     * It consumes JSON, that is: request body Todo.
     * As result it returns updated Todo.
     */
    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateTodo(@RequestBody todo: TodoDTO): TodoDTO = service.updateTodo(todo)

    @GetMapping(
        "/getScheduledLate",
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getTodosLaterThan(@RequestBody payload: TodoLaterThanRequest): Iterable<TodoDTO> = service.getScheduledLaterThan(payload.date)
}