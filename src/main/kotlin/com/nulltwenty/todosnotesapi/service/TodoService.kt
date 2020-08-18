package com.nulltwenty.todosnotesapi.service

import com.nulltwenty.todosnotesapi.data.Todo
import com.nulltwenty.todosnotesapi.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("Todo service")
class TodoService {
    @Autowired
    lateinit var repository: TodoRepository
    fun getTodos(): Iterable<Todo> = repository.findAll()
    fun insertTodo(todo: Todo) = repository.save(todo)
    fun deleteTodo(id: String) = repository.deleteById(id)
    fun updateTodo(todo: Todo): Todo = repository.save(todo)
}