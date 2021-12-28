package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * @Project kotlin-essentials
 * @Author mave on 12/20/21
 */
class ForDemo {
}

/**
 * Goal:
 *  - Formulate a proper way to wait/suspend the running thread for coroutines
 *      completion or vice-versa
 */
/*
fun main() {

    println("main program starts at ${Thread.currentThread().name}")

    GlobalScope.launch { //launches a coroutine on background thrread
        println("background program starts at ${Thread.currentThread().name}")
        //second solution: Delay the coroutine(s)
        //delay(2000)
        println("background program starts at ${Thread.currentThread().name}")
    }
    //third solution: Delay the current thread
    runBlocking {
        delay(2000)
    }

    //first solution: make the running thread wait: suspend the current thread
    //  for the during of coroutines completion
    //Thread.sleep(2000)
    println("main program starts at ${Thread.currentThread().name}")
}*/

//fourth solution: To initiate runBlocking() on main thread; or beginning of the
//current thread
fun main() = runBlocking {
        println("Main program running on ${Thread.currentThread().name}")


        GlobalScope.launch {
            println("Background program running on ${Thread.currentThread().name}")
            println("Background program running on ${Thread.currentThread().name}")

        }
        delay(2000)
        println("Main program running on ${Thread.currentThread().name}")

    }
