package com.example.designpatternskotlin.flyweight

object OsShareVars {
    private var osMap = HashMap<OsType,Os>()

    fun getOs(type: OsType) : Os {
        var os = osMap.get(type)
        if (os == null) {
            os = Os(type)
            osMap.put(type,os)
        }
        return os
    }
}