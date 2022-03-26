package com.example.designpatternskotlin.template

abstract class House {
    fun buildHouse(){
        makeGirders()
        makeWall()
        makeDoorsAndWindows()
        print("House is built")
    }
    abstract fun makeGirders()
    abstract fun makeWall()
    abstract fun makeDoorsAndWindows()
}

class Type1House() : House() {
    override fun makeGirders() {
        // some special girder for wood house
    }

    override fun makeWall() {
        // some special wall for wood house
    }

    override fun makeDoorsAndWindows() {
        // some special doors and windows for wood house
    }
}

class Type2House() : House() {
    override fun makeGirders() {
        // some special girder for wood house
    }

    override fun makeWall() {
        // some special wall for wood house
    }

    override fun makeDoorsAndWindows() {
        // some special doors and windows for wood house
    }
}