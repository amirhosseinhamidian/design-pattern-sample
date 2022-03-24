package com.example.designpatternskotlin.observer

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

class Thermometer {
    var support : PropertyChangeSupport = PropertyChangeSupport(this)
    var temperature : Int = 0

        set(value) {
            support.firePropertyChange("temperature", temperature, value)
            field = value
        }

    fun addPropertyChangeListener(pcl: PropertyChangeListener?) {
        support.addPropertyChangeListener(pcl)
    }

    fun removePropertyChangeListener(pcl: PropertyChangeListener?) {
        support.removePropertyChangeListener(pcl)
    }
}