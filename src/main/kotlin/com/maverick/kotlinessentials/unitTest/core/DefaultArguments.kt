/*
package com.maverick.kotlinessentials.unitTest.core


//need 'open' to inherit
open class DefaultArguments(
    //Class level default arguments
    name: String = "",
    age: Int = 0,
    salary: Double = 0.0,
    testAtt: Int
) {
    val message = "hello world!!"
    fun memberFunction(): String{
        return "memeber function"
    }
    //need 'open' to override
    open fun defaultArgsDemo(arg1: Int = 16, arg2: String = "defaultString"): String{
        return "From DefaultArguments $arg1 $arg2"
    }
}
class DefaultArguments2 : DefaultArguments(testAtt = 13){
    override fun defaultArgsDemo(arg1: Int , arg2: String): String {
        return "From DefaultArguments2 $arg1 $arg2"
    }
}
fun main() {
    //calling member function
    val tempVar = DefaultArguments(testAtt = 15).memberFunction()
    println("Member function $tempVar")

    //calling class-level default arguments
    val tempVar3 = DefaultArguments("Kishan", 23, 2344.42, testAtt = 13)
    println("Class-level: ${tempVar3.defaultArgsDemo()}")

    //calling method level default args
    val tempVar2 =  DefaultArguments2().defaultArgsDemo(20, "newString")
    println("Method-level args: $tempVar2")

    //default param before param without default value
    val tempVar4 = DefaultArguments(testAtt = 13)
    println("Default over without default value $tempVar4")
}*/
