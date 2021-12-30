/*
package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.*

*/
/**
 * @Project kotlin-essentials
 * @Author mave on 12/26/21
 *//*

class CoroutineCancellation {
}

*/
/**
 * kotlinx.coroutines for cooperative coroutines
 *  - delay()
 *  - yield()
 *  - withTimeout()
 *  - withContext()
 *//*


fun main() = runBlocking {
    println("\nmain taks starts on ${Thread.currentThread().name}")

    val job: Job = launch {
        println("\nbackground task on ${Thread.currentThread().name}")
        try {
            for (i in 0..500) {
                print("$i.")
                yield()
                //Thread.sleep(50)
                delay(50)
            }
        } catch (ex: CancellationException) {
            println("\n${ex.message}")
        } finally {
            //delay() wrapped inside withContext(NonCancellable)
            withContext(NonCancellable) {
                println(" finally in ${Thread.currentThread().name}")
                delay(1000)
                println("Finally block executed...")
            }
        }
    }
    delay(10)
    job.cancel(CancellationException("Coroutine: ${coroutineContext} cancelling Job: ${job} on thread: ${Thread.currentThread().name}"))
    job.join()
    println("\nmain tasks ends on ${Thread.currentThread().name}")
}

*/
