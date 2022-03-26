package com.example.designpatternskotlin.strategy

class SortDescendStrategy : Strategy{
    override fun action(list: List<Int>): List<Int> {
        return list.sortedByDescending { it }
    }

}