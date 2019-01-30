package com.hjchanna.todo

import com.hjchanna.todo.utils.CommandLineInput
import com.hjchanna.todo.utils.CommandLineInputHandler

class TodoApp {
    def static DEFAULT_INPUT = '\u0000'

    static void main(String[] args) {
        CommandLineInput commandLineInput

        while (commandLineInput != CommandLineInput.EXIT) {
            CommandLineInputHandler.instance.with {
                printOptions()

                def input = readInput("Please enter your choice: ")
                def inputChars = (input.length() == 1 ? input.toCharArray() : [DEFAULT_INPUT]) as Character[]
                commandLineInput = CommandLineInput.getCommandLineInput(inputChars[0])
                processInput(commandLineInput)


                readInput("press return to continue...")
            }
        }
    }
}
