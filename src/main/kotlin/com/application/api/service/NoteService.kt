package com.application.api.service

import com.application.api.data.Note
import com.application.api.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("Note Service")
class NoteService{

    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<Note> = repository.findAll()

    fun insertNote(note: Note): Note = repository.save(note)

    fun deleteNote(id: String) = repository.deleteById(id)

    fun updateNote(note: Note): Note = repository.save(note)
}
