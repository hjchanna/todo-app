package com.hjchanna.todo.repository

import com.hjchanna.todo.model.ToDoItem

interface ToDoRepository {
    List<ToDoItem> findAll()

    ToDoItem findById(Long id)

    Long insert(ToDoItem toDoItem)

    void update(ToDoItem toDoItem)

    void delete(ToDoItem toDoItem)
}