package com.maverick.kotlinessentials.unitTest.functional

class KotlinLambdas

/**
 * In absence of lambdas, we need to pass the function name as the parmeter
 */

fun b(): String {
    return "hello from b"
}

fun a(lambdaParam: () -> String): String {
    return b()
}

fun c(): () -> String {
    return ::b
}

// lambda declaration
val helloAgain = { age: Int ->
    println("hello $age")
}

val lambdaWithTwoParam = { name: String, _: String -> "hello world $name" }
fun main() {
    // println(c()())
    // println(a(::b))

    // lambda declaration with a parameter
    val hello = { name: String ->
        println("hello")
        println("hello $name")
    }
    hello("Om")
    helloAgain(100)

    println(lambdaWithTwoParam("Kunal", "Shrestha"))
}
