package com.example.designpatternskotlin.adapter

class Mp4Player : MoviePlayer {
    override fun playVlc(mediaType: String, name: String) {
        //do nothing
    }

    override fun playMp4(mediaType: String, name: String) {
        if (mediaType.equals("mp4")) {
            println("Playing mp4 file. name: $name")
        }else{
            println("Invalid media. $mediaType format not supported")
        }
    }
}