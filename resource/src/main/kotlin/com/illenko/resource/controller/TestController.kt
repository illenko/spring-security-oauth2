package com.illenko.resource.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {

    @GetMapping("/test")
    fun test(): Array<String> {
        return arrayOf("Test 1", "Test 2", "Test 3")
    }

}