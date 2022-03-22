package com.example.designpatternskotlin.builder

import android.util.Log

class Shape
private constructor(
    val perimeter: Float?,
    val area: Float?,
    val color: Int?,
    val name: String?
){
    data class Builder(
        var perimeter: Float? = null,
        var area: Float? = null,
        var color: Int? = null,
        var name: String? = null
    ) {
        fun perimeter(perimeter:Float) = apply { this.perimeter = perimeter }
        fun area(area:Float) = apply { this.area = area}
        fun color(color:Int) = apply { this.color = color }
        fun name(name:String) = apply { this.name = name }
        fun build() = Shape(perimeter,area,color,name)
    }

    fun getLog() {
        Log.e(TAG, "perimeter: $perimeter\n area: $area\n color: $color\n name: $name")
    }

    companion object {
        private const val TAG = "Shape"
    }

}