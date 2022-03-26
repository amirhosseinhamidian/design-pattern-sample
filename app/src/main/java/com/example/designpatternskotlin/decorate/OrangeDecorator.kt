package com.example.designpatternskotlin.decorate

abstract class OrangeDecorator (var orange: Orange) : Orange(){
}

class BloodyOrange(orange: Orange) : OrangeDecorator(orange){
    override fun getName(): String = orange.getName() + " Bloody"
}

class ThompsonOrange(orange: Orange) : OrangeDecorator(orange){
    override fun getName(): String = orange.getName() + " Thompson"
}

class BigOrange(orange: Orange) : OrangeDecorator(orange){
    override fun getName(): String = orange.getName() + " Big"
}