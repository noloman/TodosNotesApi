package com.nulltwenty.todosnotesapi.controller

import com.nulltwenty.todosnotesapi.data.Todo
import com.nulltwenty.todosnotesapi.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController {
    @Autowired
    lateinit var service: TodoService

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getTodos(): List<Todo> = service.getTodos()

    @PutMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun insertTodo(@RequestBody todo: Todo): Todo = service.insertTodo(todo)

    @DeleteMapping(
        value = ["/delete/{id}"],
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean = service.deleteTodo(id)

    @PostMapping(
        produces = [MediaType.APPLICATION_JSON_VALUE],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun updateTodo(@RequestBody todo: Todo): Todo = service.updateTodo(todo)
}