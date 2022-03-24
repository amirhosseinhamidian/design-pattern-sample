package com.example.designpatternskotlin.prototype

class ShapeCloneMaker {
    val shapeMap = HashMap<String,ShapeClone>()
    init {
        shapeMap["circle"] = ShapeClone("circle")
        shapeMap["oval"] = ShapeClone("oval")
    }

    fun getShape(key:String) : ShapeClone? {
        if (shapeMap.containsKey(key)) {
            return(shapeMap[key]!!.clone() as ShapeClone)
        }
        return null
    }
}