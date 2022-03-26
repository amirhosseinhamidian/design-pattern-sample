package com.example.designpatternskotlin.chainofresponsibility

import android.util.Log

data class Job(val name : String , val isEasy : Boolean, val isForce : Boolean, val isFast : Boolean)

abstract class Handler(var handler : Handler?){
    var isBusy = false
    open fun handle(job: Job){
        handler?.handle(job)
    }
}

class SeniorLevel(handler: Handler?) : Handler(handler){
    override fun handle(job: Job) {
        if (!isBusy && !job.isEasy && job.isFast && job.isForce) {
            isBusy = false
            Log.e("chain","SeniorLevel is doing job ${job.name}")
        }else {
            super.handle(job)
        }
    }
}

class MidLevel(handler: Handler?) : Handler(handler){
    override fun handle(job: Job){
        if(!isBusy)
        {
            isBusy = false
            // write some code for timer
            Log.e("chain","MidLevel is doing job ${job.name}")
        }
        else
            super.handle(job)
    }
}

class JuniorLevel(handler: Handler?) : Handler(handler) {
    override fun handle(job: Job) {
        if (!isBusy && job.isEasy && !job.isForce && !job.isFast) {
            isBusy = false
            // write some code for timer
            Log.e("chain","JuniorLevel is doing job ${job.name}")
        } else
            super.handle(job)
    }
}


class Chain(var handler: Handler)
