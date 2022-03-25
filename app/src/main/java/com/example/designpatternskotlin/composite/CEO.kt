package com.example.designpatternskotlin.composite

class CEO(name : String , var nodes : MutableList<Human> = ArrayList()) : Human(name) {
    override fun printName() {
        println("CEO is $name")
    }

    fun addNode(node : Human) {
        nodes.add(node)
    }

    override fun showNodes() {
        println("$name is CEO and he/she has nodes")
        for (item in nodes) {
            item.showNodes()
        }
    }
}