package com.example.designpatternskotlin.composite

class CTO(name : String , var nodes : MutableList<Human> = ArrayList()) : Human(name) {
    override fun printName() {
        println("CTO is $name")
    }

    override fun showNodes() {
        for (item in nodes){
            item.showNodes();
        }
    }

    fun addNode(node : Human){
        println("$name is CTO and he/she has nodes : ")
        nodes.add(node)
    }
}