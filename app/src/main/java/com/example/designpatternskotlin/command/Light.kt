package com.example.designpatternskotlin.command

import android.graphics.Color

// receiver part
class Light {
    var color : Int = Color.WHITE

    fun red() {
        color = Color.RED
    }

    fun blue() {
        color = Color.BLUE
    }

    fun white() {
        color = Color.WHITE
    }
}