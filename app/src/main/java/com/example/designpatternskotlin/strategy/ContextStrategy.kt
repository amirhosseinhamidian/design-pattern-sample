package com.example.designpatternskotlin.strategy

class ContextStrategy(var strategy: Strategy, var list: List<Int>) {
    fun doStrategy() :List<Int> {return strategy.action(list)}
}