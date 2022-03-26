package com.example.designpatternskotlin.objectpool

abstract class ObjectPool<T> {
    var expirationTime : Long = 5000;
    var locked = HashMap<T,Long>()
    var unLocked = HashMap<T,Long>()

    abstract fun create() : T

    abstract fun validate(obj : T) : Boolean

    abstract fun expire (obj: T)

    @Synchronized fun checkOut() : T{
        val timeNow = System.currentTimeMillis()
        if(unLocked.size > 0){
            val e = unLocked.keys.toList()
            for(item in e){
                if(timeNow - unLocked[item]!! > expirationTime){
                    unLocked.remove(item)
                    expire(item)
                }else if(validate(item)){
                    unLocked.remove(item)
                    locked.put(item,timeNow)
                    return item
                }else{
                    unLocked.remove(item)
                    expire(item)
                }
            }
        }
        val ret = create()
        locked.put(ret,timeNow)
        return ret
    }

    @Synchronized fun checkIn(obj : T){
        locked.remove(obj)
        unLocked.put(obj,System.currentTimeMillis())
    }
}