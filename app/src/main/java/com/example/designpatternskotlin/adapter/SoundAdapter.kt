package com.example.designpatternskotlin.adapter

class SoundAdapter : SoundPlayer {
    var moviePlayer : MoviePlayer? = null
    var audioPlayer : SoundPlayer? = null

    override fun play(audioType: String, name: String) {
        if (audioType.equals("mp3")) {
            audioPlayer = AudioPlayer()
            audioPlayer!!.play(audioType,name)
        } else if (audioType.equals("mp4")) {
            moviePlayer = Mp4Player()
            moviePlayer!!.playMp4(audioType,name)
        } else if (audioType.equals("vlc")) {
            moviePlayer = VlcPlayer()
            moviePlayer!!.playVlc(audioType,name)
        }
    }
}