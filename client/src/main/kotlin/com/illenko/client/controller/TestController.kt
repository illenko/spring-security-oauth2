package com.illenko.client.controller

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient


@RestController
class TestController(private val webClient: WebClient) {

    @GetMapping(value = ["/test"])
    fun test(
        @RegisteredOAuth2AuthorizedClient("backend-client-authorization-code") authorizedClient: OAuth2AuthorizedClient
    ): Array<String> {
        return webClient
            .get()
            .uri("http://127.0.0.1:8090/test")
            .attributes(oauth2AuthorizedClient(authorizedClient))
            .retrieve()
            .bodyToMono(Array<String>::class.java)
            .block()!!
    }
}