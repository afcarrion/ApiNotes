package com.application.api.repository

import com.application.api.data.Todo
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, String>{

    @Query("from Todo t where t.schedule > ?1")
    fun findScheduledLaterThan(date:Long): Iterable<Todo>
}
