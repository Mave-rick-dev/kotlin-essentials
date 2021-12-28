package com.maverick.kotlinessentials.controller

import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Project kotlin-essentials
 * @Author mave on 12/27/21
 */
class CoroutineScopeDemo2 {
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