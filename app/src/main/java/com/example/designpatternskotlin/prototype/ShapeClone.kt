package com.example.designpatternskotlin.prototype

class ShapeClone(var name : String) : Cloneable{

    @Throws(CloneNotSupportedException::class)
    public override fun clone(): Any {
        //If you need to make changes to the clone, you should apply here.
        return super.clone()
    }
}