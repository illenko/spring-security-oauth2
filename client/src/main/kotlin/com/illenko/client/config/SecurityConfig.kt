package com.illenko.client.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.Customizer
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .authorizeRequests(
                Customizer { authorizeRequests ->
                    authorizeRequests.anyRequest().authenticated()
                }
            )
            .oauth2Login { oauth2Login: OAuth2LoginConfigurer<HttpSecurity?> ->
                oauth2Login.loginPage(
                    "/oauth2/authorization/backend-client-oidc"
                )
            }
            .oauth2Client(withDefaults())
        return http.build()
    }
}