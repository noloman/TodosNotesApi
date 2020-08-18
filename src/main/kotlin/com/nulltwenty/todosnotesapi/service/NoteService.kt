package com.nulltwenty.todosnotesapi.service

import com.nulltwenty.todosnotesapi.data.Note
import com.nulltwenty.todosnotesapi.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("Note service")
class NoteService {
    @Autowired
    lateinit var repository: NoteRepository

    fun getNotes(): Iterable<Note> = repository.findAll()
    fun insertNote(note: Note) = repository.save(note)
    fun deleteNote(id: String) = repository.deleteById(id)
    fun updateNote(note: Note) = repository.save(note)
}