package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * @Project kotlin-essentials
 * @Author mave on 12/20/21
 */
class CustomSuspend {
}

fun main() = runBlocking{

    println("some tasks initiates...${Thread.currentThread().name}")

    GlobalScope.launch {
        println("some tasks initiates...${Thread.currentThread().name}")

        println("some tasks ends...${Thread.currentThread().name}")

    }
    calcWhileWait(2000)
    print("some tasks ends... ${Thread.currentThread().name}")
}
suspend fun calcWhileWait(millis: Long){
    //some calculation
    delay(millis)
}