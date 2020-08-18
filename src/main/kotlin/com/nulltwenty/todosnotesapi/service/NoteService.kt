package com.nulltwenty.todosnotesapi.service

import com.nulltwenty.todosnotesapi.data.Note
import org.springframework.stereotype.Service
import java.util.*

@Service("Note service")
class NoteService {
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

    fun insertNote(note: Note): Note {
        note.id = UUID.randomUUID().toString()
        return note
    }

    fun deleteNote(id: String): Boolean = false
    fun updateNote(note: Note): Boolean = true
}