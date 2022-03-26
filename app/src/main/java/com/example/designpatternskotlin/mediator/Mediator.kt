package com.example.designpatternskotlin.mediator

interface Mediator {
    fun sendMessage(msg : String , sender : Hardware , receiver : Hardware)
}

abstract class Hardware(var mediator: Mediator){

    fun sendMessage(msg: String , hardware: Hardware) {
        mediator.sendMessage(msg,this,hardware)
    }

    abstract fun receiverMessage(msg: String , hardware: Hardware)
}