/*
package com.maverick.kotlinessentials.unitTest.coroutines

import kotlinx.coroutines.*

*/
/**
 * @Project kotlin-essentials
 * @Author mave on 12/27/21
 *//*

class AsyncDemo {
}

fun main()= runBlocking {

    val deferredJob: Deferred<String> = async{
        //some task

        println("background task running on thread: ${Thread.currentThread().name}")
        delay(2000)
        "something to return"
    }
    val result: String = deferredJob.await()
    println(result)
    deferredJob.join()
    println("main task running on thread: ${Thread.currentThread().name}")
}*/
