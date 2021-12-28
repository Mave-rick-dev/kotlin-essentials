/*
package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking



class CoroutineScopeDemo {



}

fun main(): Unit = runBlocking {

    println("runBlocking coroutine scope: $this")

    launch {
        println("parent coroutine scope: $this")

        launch {
            println("child coroutine scope: $this")

        }
    }

    async {
        println("async coroutine scope: $this")
        "return type"
    }
}
*/
