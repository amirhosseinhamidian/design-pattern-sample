package com.example.designpatternskotlin.memento

//Originator
class ClipBoard {
    var data = ""
    var dataSize = 0
    fun copy(str : String) : Memento {
        data = str
        dataSize = data.length
        return Memento(data)
    }
}

class Memento(var data : String)