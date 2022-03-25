package com.example.designpatternskotlin.iterator

import android.util.Log

class TreeIterator(var tree : Array<Int>) : Iterator<Int>{
    var pos = 0
    var calculationPos = 0
    var leftChecked = false
    override fun hasNext(): Boolean {
        if (tree.size > calculationPos*2)
            return true
        else{
            pos = 0
            calculationPos = 0
            leftChecked = false
            return false
        }
    }

    override fun next(): Int {
        if (!leftChecked) {
            leftChecked = true
            val element = tree[calculationPos++*2]
            Log.e("iteratorPattern",element.toString())
            return element
        }else{
            leftChecked = false
            val element = tree[pos++*2 + 1]
            Log.e("iteratorPattern",element.toString())
            return element
        }
    }
}

interface Collection {
    fun createIterator() : Iterator<Int?>
}

class TreeCollection(var tree : Array<Int>) : Collection {
    private var pos = 0
    fun addToTree(value : Int){
        tree[pos++] = value
    }
    override fun createIterator(): Iterator<Int?> = TreeIterator(tree)

}