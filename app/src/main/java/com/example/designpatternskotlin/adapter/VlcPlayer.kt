package com.example.designpatternskotlin.adapter

import com.example.designpatternskotlin.adapter.MoviePlayer

class VlcPlayer: MoviePlayer {
    override fun playVlc(mediaType: String, name: String) {
        if (mediaType.equals("vlc")) {
            println("Playing vlc file. name: $name")
        }else {
            println("Invalid media. $mediaType format not supported")
        }
    }

    override fun playMp4(mediaType: String, name: String) {
        //do nothing
    }
}