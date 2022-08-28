package com.illenko.client.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeRequests {
                it.anyRequest().authenticated()
            }
            .oauth2Login {
                it.loginPage("/oauth2/authorization/backend-client-oidc")
            }
            .oauth2Client(withDefaults())
        return http.build()
    }
}