package com.hjchanna.todo.utils

enum CommandLineInput {
    FIND_ALL('a' as Character), FIND_BY_ID('f' as Character), INSERT('i' as Character), UPDATE('u' as Character), DELETE('d' as Character), EXIT('e' as Character)

    private static final Map<Character, CommandLineInput> INPUTS

    static {
        INPUTS = new HashMap<>()
        values().each {
            INPUTS.put(it.shortCommand, it)
        }
    }

    private Character shortCommand

    private CommandLineInput(Character command) {
        shortCommand = command
    }

    static CommandLineInput getCommandLineInput(Character input) {
        INPUTS.get(input as Character)
    }
}
