package com.application.api.data

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.util.*

@Entity
@Table(name="note")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Note(
    @Id
    @GeneratedValue(generator= "uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @Column(columnDefinition="varchar(36)")
    var id: String = "",
    var title: String,
    var message: String?,
    var location: String = "",
    @CreationTimestamp
    var created: Date = Date(),
    @UpdateTimestamp
    var modified: Date = Date())
    {
        constructor() : this("","","","")
    }

@Entity
@Table(name="todo")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Todo(
    @Id
    @GeneratedValue(generator="uuid2")
    @GenericGenerator(name="uuid2", strategy="uuid2")
    @Column(columnDefinition = "varchar(36)")
    var id : String = "",
    var title: String,
    var message: String,
    var schedule: String,
    var location: String = "",
    @CreationTimestamp
    var created: Date = Date(),
    @UpdateTimestamp
    var modified: Date = Date())
    {
        constructor():this("","","","")
    }