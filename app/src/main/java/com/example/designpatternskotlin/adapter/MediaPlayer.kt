package com.example.designpatternskotlin.adapter

class MediaPlayer (var soundPlayer: SoundPlayer){
    fun play(audioType :String , name:String) {
        soundPlayer.play(audioType,name)
    }
}