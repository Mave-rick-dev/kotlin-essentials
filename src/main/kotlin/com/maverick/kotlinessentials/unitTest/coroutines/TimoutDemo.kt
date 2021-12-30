/*
package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.*

*/
/**
 * @Project kotlin-essentials
 * @Author mave on 12/27/21
 *//*

class TimoutDemo {
}

fun main() = runBlocking {

    println("main task starts on ${Thread.currentThread().name}")

    //withTimeout(millis: Long)
   */
/* try {
        withTimeout(2000) {
            for (i in 0..500) {
                print("$i.")
                delay(100)
            }
        }
    }catch (ex: TimeoutCancellationException){
        println("\n${ex.message}")
    }finally {
        println("finally block executed....")
    }*//*


    //withTimeoutOrNull(millis: Long)
    val result: String? = withTimeoutOrNull(2000){
        for(i in 0..10){
            //delay(500)
            print("$i.")
        }
        "return value here..."
    }
    println("\nReturned value: $result")
    println("main task starts on ${Thread.currentThread().name}")

}*/
