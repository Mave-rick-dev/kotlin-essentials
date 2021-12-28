package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.*

/**
 * @Project kotlin-essentials
 * @Author mave on 12/17/21
 */
/**
 *
 */
class CoRoutinesDemo {}

fun main() {

    //coroutine without context: run coroutine with non-blocking nature
    fun checkCheck2(){
        println("Before2")
        //launches a co-routine and assigns the block below
        //to a separate thread, hence executing "after2"
        /**
         * .launch: non-blocking co-routing builder
         *      which doesn't wait for it's block i.e
         *      executes it's block in a separate thread
         */
        GlobalScope.launch {
           // println("running2...")
            delay(1000)
            println("completed2")
        }
        println("out side")
        println("after2")
    }

    //checkCheck2()

    //coroutine with context: run coroutine with blocking nature
    suspend fun checkcheck1(){
        println("Before context...")
        withContext(Dispatchers.IO){

        }
    }
}















