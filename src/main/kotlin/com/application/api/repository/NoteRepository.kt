package com.application.api.repository

import com.application.api.data.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, String>{
    fun findByTitle(title: String): Iterable<Note>
}


