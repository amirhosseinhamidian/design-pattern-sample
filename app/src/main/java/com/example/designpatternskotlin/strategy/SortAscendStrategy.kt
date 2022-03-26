package com.example.designpatternskotlin.strategy

class SortAscendStrategy : Strategy{
    override fun action(list: List<Int>): List<Int> {
        return list.sortedBy { it }
    }
}