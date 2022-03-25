package com.maverick.kotlinessentials.unitTest

class TempTest

// main function
fun main() {
    println("hello world from main fun")
    /**
     * '::' is a kotlin syntax that signifies
     *  that a is a named function defined somewhere else
     */
    println("calling b() with a as param: " + b(::a))
    println("callling c() with a as its return type: " + c())
    println("invoking a() when calling c(): " + c()())

    // iii demo
    val returnedFunction = c()
    println("invoking a() from a val: " + returnedFunction())
    println("a() returned from c(): $returnedFunction")
    val returnedFunctionValue = c()()
    println("a() invoked from c(): $returnedFunctionValue")

    // lambda with param as function
    println(alternativeLambda("Nikesh", 32))
}

// higher order function
/**
 * features:
 *  i. can have return-type a function
 *  ii. can have parameter as function
 *  iii. can be initialized in a var|val
 */

// i demo
fun c(): () -> String {
    return ::a
}

fun a(): String {
    return "from  a re..."
}

// ii demo
fun b(functionalParam: () -> String): String {
    return a()
}

/**
 *  lambda:
 *      - basically eliminates the need to define the signature of a fun
 *      - treats fun itself as data
 */

// function: returns string "..."
fun d(name: String, age: Int): String {
    // some processing...
    return "from d..."
}

val alternativeLambda = { name: String, age: Int ->
    // some processing
    name + age
}
