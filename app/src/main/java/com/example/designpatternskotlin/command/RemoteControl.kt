package com.example.designpatternskotlin.command

import java.util.*

class RemoteControl {
    private val commandStack : Stack<Command> = Stack()

    fun pressButton(command: Command) {
        command.execute()
        commandStack.push(command)
    }

    fun undoButton() {
        if (!commandStack.isEmpty()) {
            val lastCommand = commandStack.pop()
            lastCommand.undo()
        }
    }

    fun getStackLog() {
        if (!commandStack.isEmpty()) {
            for (i in 0..commandStack.size) {
                println("light : ${commandStack.get(i)}")
            }
        }
    }
}