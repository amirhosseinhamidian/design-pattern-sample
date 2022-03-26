package com.example.designpatternskotlin.memento

//Caretaker
class CareTaker {
    private val mementoList: MutableList<Memento> = ArrayList()

    fun add(state: Memento) {
        mementoList.add(state)
    }

    fun get(index: Int): Memento? {
        if(index < mementoList.size)
            return mementoList[index]
        return null
    }

    fun undo() : Memento?{
        if(!mementoList.isEmpty()){
            val ret = mementoList.last()
            mementoList.remove(ret)
            return ret
        }
        return null
    }
}