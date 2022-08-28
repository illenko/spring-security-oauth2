package com.illenko.client.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http.authorizeRequests { it.anyRequest().authenticated() }
            .oauth2Login { it.loginPage("/oauth2/authorization/client-oidc") }
            .oauth2Client(withDefaults()).build()
}