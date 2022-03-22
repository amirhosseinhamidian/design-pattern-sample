package com.example.designpatternskotlin.facade

class Speaker {
    var on = false

    fun playSong(songName : String){
        if (on) {
            println("play $songName")
        }
    }

    fun on() {
        on = true
    }

    fun off() {
        on = false
    }
}