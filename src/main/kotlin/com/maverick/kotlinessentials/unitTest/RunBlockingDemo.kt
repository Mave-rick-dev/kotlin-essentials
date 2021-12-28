package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.delay

/**
 * @Project kotlin-essentials
 * @Author mave on 12/27/21
 */
class RunBlockingDemo {
}
/**
 * runBlocking should not be call from a coroutine and is
 * mosty used for writing test cases for suspending functions
 *  Below function is to be tested with runBlocing in RunBlockingDemoTest class
 */

suspend fun waitAndCalc(millis: Long,num1: Int, num2: Int){
    val sum: Int = num1 + num2
    println("calculating...")
    delay(millis)
    println("Result: $sum")
}