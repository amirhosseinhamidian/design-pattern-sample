package com.example.designpatternskotlin.command

// command parts
interface Command {
    fun execute()
    fun undo()
}