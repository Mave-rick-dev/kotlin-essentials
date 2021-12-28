package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * @Project kotlin-essentials
 * @Author mave on 12/24/21
 */
class TempTest {

}

/*
fun main(): Unit = runBlocking {
    println("C1 on thread ${Thread.currentThread().name}")

    //inherits parent's scope
    launch(coroutineContext){
        println("C2 on thread ${Thread.currentThread().name}")
        delay(2000)
        println("C2 on thread ${Thread.currentThread().name}")
    }

    //confined; same context as parent's
    launch {
        println("Confined:")
        println("C4 on thread ${Thread.currentThread().name}")
        delay(2000)
        //always same thread as parent
        println("C4 after delay on thread ${Thread.currentThread().name}")

    }

    //default dispatcher == globalScope
    launch(Dispatchers.Default) {
        println("Default:")
        println("C3 on thread ${Thread.currentThread().name}")
        delay(2000)
        //may not on the same app-level thread
        println("C3 after delay on thread ${Thread.currentThread().name}")
    }

    //unconfined
    launch(Dispatchers.Unconfined){
        println("unconfined:")
        println("C5 on thread ${Thread.currentThread().name}")
        delay(2000)
        //may not on the same app-level thread
        println("C5 after delay on thread ${Thread.currentThread().name}")
    }
    println("C1 on thread ${Thread.currentThread().name}")

}*/
