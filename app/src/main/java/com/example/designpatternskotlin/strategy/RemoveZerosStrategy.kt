package com.example.designpatternskotlin.strategy

class RemoveZerosStrategy : Strategy {
    override fun action(list: List<Int>): List<Int> {
        val tempList = list.toMutableList()
        tempList.removeAll{it == 0}
        return tempList
    }
}