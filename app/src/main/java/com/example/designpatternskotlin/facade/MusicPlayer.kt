package com.example.designpatternskotlin.facade

class MusicPlayer {

    var on = false

    var song: String? = null
    var screen: Screen? = null
    var speaker: Speaker? = null

    fun playSong(songName:String) {
        if (on) {
            song = songName
        }
    }

    fun on() {
        on = true
    }

    fun off() {
        on = false
    }

}