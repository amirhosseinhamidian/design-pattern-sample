package com.example.designpatternskotlin.adapter

interface MoviePlayer {
    fun playVlc(mediaType:String, name:String)
    fun playMp4(mediaType: String, name: String)
}