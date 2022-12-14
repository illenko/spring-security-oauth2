package com.illenko.resource.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class ResourceServerConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.mvcMatcher("/test/**")
            .authorizeRequests()
            .mvcMatchers("/test/**")
            .access("hasAuthority('SCOPE_backend.read')")
            .and()
            .oauth2ResourceServer()
            .jwt()
        return http.build()
    }
}