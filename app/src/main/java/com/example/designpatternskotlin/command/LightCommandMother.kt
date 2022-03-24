package com.example.designpatternskotlin.command

//ConcreteCommand part
abstract class LightCommandMother (var light: Light) : Command{
    var lastStatus: Int = light.color

    override fun undo() {
        light.color = lastStatus
    }
}

class LightBlueCommand(light: Light) : LightCommandMother(light) {
    override fun execute() {
        light.blue()
    }
}

class LightWhiteCommand(light: Light) : LightCommandMother(light) {
    override fun execute() {
        light.white()
    }
}

class LightRedCommand(light: Light) : LightCommandMother(light) {
    override fun execute() {
        light.red()
    }
}