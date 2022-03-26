package com.example.designpatternskotlin.objectpool

class Computer {
    var pluggedIn = true
}

class ComputerObjectPool : ObjectPool<Computer>() {
    override fun create(): Computer = Computer()

    override fun validate(obj: Computer): Boolean = obj.pluggedIn

    override fun expire(obj: Computer) {
        obj.pluggedIn = false
    }

}