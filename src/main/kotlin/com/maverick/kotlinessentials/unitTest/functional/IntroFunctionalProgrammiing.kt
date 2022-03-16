/*
package com.maverick.kotlinessentials.unitTest.functional


class IntroFunctionalProgrammiing

fun functionThatReturnsString(): String {
    return "hello String!!"
}

*/
/**
 * @param functionalParam is a lambda and not a function, hence passing function functionThatReturnsString()
 *  gives compile time exception
 *  @throws CompileTimeException if not surrounded with {} or ::
 *//*

fun higherOrderFunctionWithParamAsFunction(functionalParam: () -> String, age: Int): String {
    return functionalParam() + " " + age
}

fun higherOrderFunctionWithReturnAsFunction(): () -> String {
    return ::functionThatReturnsString
}
fun main() {
    println(higherOrderFunctionWithReturnAsFunction()())
    println(higherOrderFunctionWithReturnAsFunction())
    println(higherOrderFunctionWithParamAsFunction(::functionThatReturnsString, 10))
}
*/
