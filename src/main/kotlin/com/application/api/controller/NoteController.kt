package com.application.api.controller

import com.application.api.data.Note
import com.application.api.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
@EnableAutoConfiguration
class NoteController {

    @Autowired
    private lateinit var service: NoteService

    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNotes() = service.getNotes()

    /**
     *Insert Note.
     * It consmes  JSON, that is: request body Note
     */
    @PostMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun insertNote(
        @RequestBody note: Note
    ) = service.insertNote(note)

    /**
     * Delete Note.
     * REmove Note by ID. We introduced path variable for ID to pass
     */
    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteNote(@PathVariable(name = "id") id: String): Boolean = service.deleteNote(id)

    /**
     * Update item.
     * It consumes JSON, that is : request body note
     * As result it returns update Note.
     */
    @PutMapping(
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun updateNote(@RequestBody note: Note): Boolean = service.updateNote(note)
}