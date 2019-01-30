package com.hjchanna.todo.model

class ToDoItem implements Comparable<ToDoItem> {
    Long id
    String name
    Boolean completed

    @Override
    int compareTo(ToDoItem o) {
        id <=> o.id
    }

    @Override
    String toString() {
        "[$id] $name - ${completed ? 'Completed' : 'Pending'}"
    }
}
