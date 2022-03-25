package com.example.designpatternskotlin.interpreter

class Context {
    fun getIntFormat(number : String) : Int {
        return number.toInt()
    }
}

interface Expression {
    fun interpret(context: Context) : Int
}

class Add(var left : Expression , var right : Expression) : Expression {
    override fun interpret(context: Context): Int {
        return left.interpret(context) + right.interpret(context)
    }
}

class Sub(var left : Expression, var right : Expression) : Expression {
    override fun interpret(context: Context): Int {
        return left.interpret(context) - right.interpret(context)
    }
}

class Terminal(var number : String) : Expression {
    override fun interpret(context: Context): Int {
        return context.getIntFormat(number)
    }

}