package com.nulltwenty.todosnotesapi.controller

import com.nulltwenty.todosnotesapi.data.Todo
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/todos")
class TodoController {
    @GetMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getNotes(): List<Todo> = listOf(
        Todo(
            id = UUID.randomUUID().toString(),
            title = "My first todo",
            message = "Message for 1st todo",
            schedule = System.currentTimeMillis()
        ),
        Todo(
            id = UUID.randomUUID().toString(),
            title = "My second todo",
            message = "Message for 2nd todo",
            schedule = System.currentTimeMillis()
        )
    )

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertNote(@RequestBody todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        return todo
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
    fun updateNote(@RequestBody todo: Todo): Todo {
        todo.title += " [ updated ]"
        todo.message += " [ updated ]"
        todo.schedule += System.currentTimeMillis()
        return todo
    }
}