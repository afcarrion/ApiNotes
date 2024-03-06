package com.application.api.repository

import com.application.api.data.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, String>
