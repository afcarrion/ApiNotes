package com.application.api.service

import com.application.api.data.Note
import org.springframework.stereotype.Service
import java.util.*

@Service("Note Service")
class NoteService{
    fun getNotes(): List<Note> = listOf(
        Note(
            UUID.randomUUID().toString(),
            "My first Note",
            "this is a Messsage of the 1st note"
        ),
        Note(
            UUID.randomUUID().toString(),
            "My second Note",
            "This is a message for the second note"
        )
    )

    fun insertNote(note: Note): Note{
        note.id = UUID.randomUUID().toString()
        return note
    }

    fun deleteNote(id: String): Boolean = false

    fun updateNote(note: Note): Boolean = true
}
