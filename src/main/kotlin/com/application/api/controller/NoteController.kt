package com.application.api.controller

import com.application.api.data.Note
import com.application.api.data.NoteDTO
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
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(@RequestBody noteDTO: NoteDTO) = service.insertNote(noteDTO)

    /**
     * Delete Note.
     * REmove Note by ID. We introduced path variable for ID to pass
     */
    @DeleteMapping(
        value = ["/{id}"],
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun deleteNote(@PathVariable(name = "id") id: String) = service.deleteNote(id)

    /**
     * Update item.
     * It consumes JSON, that is : request body note
     * As result it returns update Note.
     */
    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(
        @RequestBody noteDTO: NoteDTO
    ) = service.updateNote(noteDTO)

    @GetMapping(
        "/by_title",
        produces = arrayOf(MediaType.APPLICATION_JSON_VALUE),
        consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE)
    )
    fun getTodosByTitle(
        @RequestBody payload: NoteFindByTitleRequest
    ):Iterable<NoteDTO> = service.findByTitle(payload.title)
}

data class NoteFindByTitleRequest(val title: String)