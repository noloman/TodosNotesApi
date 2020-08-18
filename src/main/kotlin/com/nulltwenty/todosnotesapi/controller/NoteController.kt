package com.nulltwenty.todosnotesapi.controller

import com.nulltwenty.todosnotesapi.data.Note
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/notes")
class NoteController {
    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNotes(): List<Note> = listOf(
        Note(
            id = UUID.randomUUID().toString(),
            title = "My first note",
            message = "Message for 1st note"
        ),
        Note(
            id = UUID.randomUUID().toString(),
            title = "My second note",
            message = "Message for 2nd note"
        )
    )

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(@RequestBody note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    @DeleteMapping(
        value = ["/delete/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteNote(@PathVariable(name = "id") id: String): Boolean {
        println("Removing $id")
        return true
    }

    @PostMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateNote(@RequestBody note: Note): Note {
        note.title += " [ updated ]"
        note.message += " [ updated ]"
        return note
    }
}