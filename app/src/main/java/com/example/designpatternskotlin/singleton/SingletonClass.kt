package com.example.designpatternskotlin.singleton

import android.util.Log

class SingletonClass {
    private object HOLDER {
        val INSTANCE = SingletonClass()
    }

    companion object {
        val instance: SingletonClass by lazy { HOLDER.INSTANCE }
        private const val TAG = "Singleton"
    }

    fun getLog() {
        Log.e(TAG, "singleton class created.")
    }
}