package com.hjchanna.todo.repository

import com.hjchanna.todo.model.ToDoItem

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong

@Singleton
class InMemoryToDoRepository implements ToDoRepository {
    private AtomicLong currentId = new AtomicLong()
    private ConcurrentHashMap<Long, ToDoItem> toDos = new ConcurrentHashMap<>()

    @Override
    List<ToDoItem> findAll() {
        return toDos.values().asList().sort()
    }

    @Override
    ToDoItem findById(Long id) {
        toDos.get(id)
    }

    @Override
    Long insert(ToDoItem toDoItem) {
        Long id = currentId.incrementAndGet()
        toDoItem.id = id
        toDoItem.completed = false
        toDos.putIfAbsent(id, toDoItem)
        return id
    }

    @Override
    void update(ToDoItem toDoItem) {
        toDos.replace(toDoItem.id, toDoItem)
    }

    @Override
    void delete(ToDoItem toDoItem) {
        toDos.remove(toDoItem.id)
    }
}
