package com.maverick.kotlinessentials.unitTest

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
/**
 * @Project kotlin-essentials
 * @Author mave on 12/27/21
 */
internal class RunBlockingDemoTest{
    
    @Test
    fun testRunBlocking() = runBlocking {

        //waitAndCalc is a suspend function which makes runBlocking
        //a better choice as it is compatible for enveloping the function
        //we want to test
        /*waitAndCalc(3000, 15 ,  15)*/
        Assert.assertEquals(30, 15 + 15)
        //arrange; given            
        
        //act; when
        
        //assert; then
        
    }
}
