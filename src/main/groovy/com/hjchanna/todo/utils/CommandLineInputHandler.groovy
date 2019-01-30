package com.hjchanna.todo.utils

import com.hjchanna.todo.repository.InMemoryToDoRepository
import com.hjchanna.todo.repository.ToDoRepository
import com.hjchanna.todo.model.ToDoItem


@Singleton
class CommandLineInputHandler {
    ToDoRepository repository = InMemoryToDoRepository.instance

    def options = [
            "(a)ll items",
            "(f)ind a specific item",
            "(i)nsert a new item",
            "(u)pdate an existing item",
            "(d)elete an item",
            "(e)xit"
    ]

    def printOptions() {
        println "-- TO DO APPLICATION --"
        options.each {
            println it
        }
    }

    def readInput(message) {
        print message

        def input = null
        while (input == null)
            input = System.in.newReader().readLine()

        return input
    }

    def processInput(CommandLineInput input) {
        switch (input) {
            case CommandLineInput.FIND_ALL:
                findAll()
                break
            case CommandLineInput.FIND_BY_ID:
                findById()
                break
            case CommandLineInput.INSERT:
                insert()
                break
            case CommandLineInput.UPDATE:
                update()
                break
            case CommandLineInput.DELETE:
                delete()
                break
            case CommandLineInput.EXIT:
                exit()
                break
            default:
                println "[ERROR] Invalid input"
        }
    }

    // ----- private methods
    def findAll() {
        def todoItems = repository
                .findAll()
        if (todoItems.isEmpty())
            println "Nothing to do, go and relax"
        else
            todoItems.each {
                println it
            }
    }

    def findById() {
        def id = readInput("Please enter todo id: ").toLong()
        def todo = repository.findById(id)

        if (todo != null) {
            println todo
        } else {
            println "No such todo found"
        }
    }

    def insert() {
        def name = readInput("Enter todo item: ")

        repository.insert(new ToDoItem(name: name))
        println "Todo inserted successfully"
    }

    def update() {
        def id = readInput("Enter todo id: ").toLong()
        def todo = repository.findById(id)

        if (todo != null) {
            def name = readInput("Enter todo item: ")
            todo.name = name

            repository.update(todo)
            println "Todo updated successfully"
        } else {
            println "No such todo found"
        }
    }

    def delete() {
        def id = readInput("Enter todo id: ").toLong()
        def todo = repository.findById(id)

        if (todo != null) {
            repository.delete(todo)
            println "Todo deleted successfully"
        } else {
            println "No such todo found"
        }
    }

    def exit() {
        println "Good Bye !!!"
    }
}
