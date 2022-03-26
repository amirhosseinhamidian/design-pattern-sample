package com.example.designpatternskotlin.mediator

import android.util.Log

class HardwareMediator() : Mediator {
    override fun sendMessage(msg: String, sender: Hardware, receiver: Hardware) {
        receiver.receiverMessage(msg,sender)
    }
}

class Ram (mediator: Mediator) : Hardware(mediator) {
    override fun receiverMessage(msg: String, hardware: Hardware) {
        Log.e("Mediator",hardware::class.java.name.toString()+" : " + msg)
    }
}

class Cpu (mediator: Mediator) : Hardware(mediator) {
    override fun receiverMessage(msg: String, hardware: Hardware) {
        Log.e("Mediator",hardware::class.java.name.toString()+" : "+msg)
    }

}