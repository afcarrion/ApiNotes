package com.application.api.service

import com.application.api.data.Todo
import com.application.api.data.TodoDTO
import com.application.api.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Todo service")
class TodoService{

    @Autowired
    lateinit var repository: TodoRepository

    fun getTodos(): Iterable<TodoDTO> = repository.findAll().map{
        it -> TodoDTO(it)
    }

    fun insertTodo(todo: TodoDTO): TodoDTO = TodoDTO(
        repository.save(
            Todo(
                title = todo.title,
                message = todo.message,
                location = todo.location,
                schedule = todo.schedule
            )
        )
    )

    fun deleteTodo(id: String) = repository.deleteById(id)

    fun updateTodo(todoDto: TodoDTO): TodoDTO{
        var todo = repository.findById(todoDto.id).get()
        todo.title = todoDto.title
        todo.message = todoDto.message
        todo.location = todoDto.location
        todo.schedule = todoDto.schedule
        todo.modified = Date()
        todo = repository.save(todo)
        return TodoDTO(todo)
    }

    fun getScheduledLaterThan(date: Date): Iterable<TodoDTO>{
        return repository.findScheduledLaterThan(date.time).map{it -> TodoDTO(it)}
    }
}