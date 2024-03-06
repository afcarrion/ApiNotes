package com.application.api.data

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name="note")
data class Note(
    @Id
    @GeneratedValue(generator= "uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @Column(columnDefinition="varchar(36)")
    var id: String = "",
    var title: String,
    var message: String,
    var location: String = "" ) {
        constructor() : this("","","","")
    }

@Entity
@Table(name="todo")
data class Todo(
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @Column(columnDefinition = "varchar(36)")
    var id : String = "",
    var title: String,
    var message: String,
    var schedule: String,
    var location: String = ""){
        constructor():this("","","","")
}