package com.example.designpatternskotlin.adapter

import com.example.designpatternskotlin.adapter.SoundPlayer

class AudioPlayer : SoundPlayer {
    override fun play(audioType: String, name: String) {
        if (audioType.equals("mp3")) {
            println("Playing mp3 file. name: $name")
        }else{
            println("Invalid media. $audioType format not supported")
        }
    }
}