package com.example.designpatternskotlin.builder

interface ShapeBuilderInterface {
    //We need to add optional parameters to the interface body.
    fun addColor(color : Int): ShapeBuilderInterface
    fun addName(name: String): ShapeBuilderInterface
}