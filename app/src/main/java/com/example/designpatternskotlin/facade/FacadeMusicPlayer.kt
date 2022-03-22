package com.example.designpatternskotlin.facade

class FacadeMusicPlayer {
    var screen = Screen()
    var speaker = Speaker()
    var musicPlayer = MusicPlayer()
    init {
        screen.speaker = speaker
        screen.musicPlayer = musicPlayer
        musicPlayer.screen = screen
        musicPlayer.speaker = speaker
    }

    fun playMusic(songName : String) {
        screen.showSongName(songName)
        screen.playSong(songName)
    }

    fun turnOnSystem() {
        if (!speaker.on) speaker.on()
        if (!musicPlayer.on) musicPlayer.on()
    }

    fun turnOffSystem(){
        if(speaker.on) speaker.off()
        if(musicPlayer.on) musicPlayer.off()
    }
}