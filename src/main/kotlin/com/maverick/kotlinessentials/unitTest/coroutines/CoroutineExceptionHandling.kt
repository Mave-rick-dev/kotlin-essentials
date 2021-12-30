/*
package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.*

*/
/**
 * @Project kotlin-essentials
 * @Author mave on 12/27/21
 *//*

class CoroutineExceptionHandling {
}

fun main() = runBlocking {
    println("main task starts in ${Thread.currentThread().name}")

    val job: Job = launch(coroutineContext) {
        try {
            println("background task starts in ${Thread.currentThread().name}")
            delay(5000)
            println("background task ends in ${Thread.currentThread().name}")
        } catch (ex: CancellationException) {
            println(ex.message)
        } finally {
            withContext(NonCancellable) {
                delay(1000)
                println("finally block")
            }
        }
    }
    delay(2000)
    job.cancel("Child coroutine taking too much time!!")
    job.join()
    println("main task ends in ${Thread.currentThread().name}")

}*/
