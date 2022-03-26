package com.example.designpatternskotlin.strategy

interface Strategy {
    fun action(list: List<Int>) : List<Int>
}