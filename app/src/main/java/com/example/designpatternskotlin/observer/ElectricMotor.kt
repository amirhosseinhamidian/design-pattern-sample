package com.example.designpatternskotlin.observer

import android.util.Log
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener

class ElectricMotor : PropertyChangeListener {
    var isOn = true
    override fun propertyChange(evt: PropertyChangeEvent?) {
        if(evt?.propertyName.equals("temperature")){
            val temperature = evt?.newValue as Int
            isOn = temperature > 80
            Log.d("MyLog","isOn : {$isOn}")
        }
    }
}