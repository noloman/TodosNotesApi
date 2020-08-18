package com.nulltwenty.todosnotesapi.repository

import com.nulltwenty.todosnotesapi.data.Todo
import org.springframework.data.repository.CrudRepository

interface TodoRepository : CrudRepository<Todo, String>