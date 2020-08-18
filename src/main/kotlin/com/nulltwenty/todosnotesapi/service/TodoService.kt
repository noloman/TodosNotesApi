package com.nulltwenty.todosnotesapi.service

import com.nulltwenty.todosnotesapi.data.Todo
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

@Service("Todo service")
class TodoService {
    fun getTodos(): List<Todo> = listOf(
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

    fun insertTodo(@RequestBody todo: Todo): Todo {
        todo.id = UUID.randomUUID().toString()
        return todo
    }

    fun deleteTodo(@PathVariable(name = "id") id: String): Boolean {
        println("Removing $id")
        return true
    }

    fun updateTodo(@RequestBody todo: Todo): Todo {
        todo.title += " [ updated ]"
        todo.message += " [ updated ]"
        todo.schedule += System.currentTimeMillis()
        return todo
    }
}