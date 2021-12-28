package com.maverick.kotlinessentials.controller

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlinx.coroutines.runBlocking

/**
 * @Project kotlin-essentials
 * @Author mave on 12/17/21
 */
@RestController
@RequestMapping("/test")
@Hidden
class TestController {

    @GetMapping
    fun get(): ResponseEntity<Any>{
        testFunction()
        return ResponseEntity.ok("response...")
    }

     fun testFunction()= runBlocking {
        TODO("Not yet implemented")
         println("Before...")
    }
}