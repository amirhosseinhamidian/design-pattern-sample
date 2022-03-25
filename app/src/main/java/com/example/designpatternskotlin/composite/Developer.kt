package com.example.designpatternskotlin.composite

class Developer(name : String) : Human(name) {
    override fun printName() {
        println("Developer is $name")
    }

    override fun showNodes() {
        println("$name is a leaf.")
    }
}