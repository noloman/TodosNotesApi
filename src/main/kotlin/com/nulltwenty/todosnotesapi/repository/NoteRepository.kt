package com.nulltwenty.todosnotesapi.repository

import com.nulltwenty.todosnotesapi.data.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, String>