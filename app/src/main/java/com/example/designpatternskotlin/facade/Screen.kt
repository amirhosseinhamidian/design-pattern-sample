package com.example.designpatternskotlin.facade

class Screen {

    var musicPlayer:MusicPlayer? = null
    var speaker:Speaker? = null

    fun showSongName(songName : String) {
        println("show $songName")
    }

    fun playSong(songName : String) {
        speaker?.playSong(songName)
    }

    fun turnOffMusicPlayer() {
        musicPlayer?.off()
    }

    fun turnOnMusicPlayer() {
        musicPlayer?.on()
    }

    fun turnOnSpeaker() {
        speaker?.on()
    }

    fun turnOffSpeaker() {
        speaker?.off()
    }
}