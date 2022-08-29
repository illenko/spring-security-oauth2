package com.illenko.resource.controller

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController {


    @GetMapping("/test")
    fun test(): Array<String> {
        val authentication = SecurityContextHolder.getContext().authentication

        return arrayOf(
            authentication.name,
            authentication.authorities.toString(),
            authentication.details.toString(),
            (authentication.principal as Jwt).issuer.toString(),
            (authentication.principal as Jwt).issuedAt.toString()
        )
    }

}