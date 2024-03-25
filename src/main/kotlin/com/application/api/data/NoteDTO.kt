package com.application.api.data

import java.util.*

data class NoteDTO (
    var title: String,
    var message: String?,
    var location: String = ""){

    var id: String = ""
    var created: Date = Date()
    var modified: Date = Date()

    constructor(note: Note) : this(
        note.title,
        note.message,
        note.location
    ){
        id = note.id
        created = note.created
        modified = note.modified
    }

}

data class TodoDTO(
    var title: String,
    var message: String,
    var schedule: String,
    var location:String
){
    var id: String = ""
    var created: Date = Date()
    var modified: Date = Date()

    constructor(todo:Todo):this(
        todo.title,
        todo.message,
        todo.schedule,
        todo.location
    ){
        id = todo.id
        created = todo.created
        modified = todo.modified
    }
}