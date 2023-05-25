package com.example.todolist.global.security

import com.example.todolist.global.filter.JwtRequestFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableWebSecurity
open class SecurityConfig(
    private val jwtRequestFilter: JwtRequestFilter
) {

    @Bean
    protected open fun filterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .cors()
            .and()
            .csrf().disable()
            .httpBasic().disable()

            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()

            .authorizeRequests()

            // auth
            .antMatchers(HttpMethod.POST, "/auth/**").permitAll()

            // post
            .antMatchers(HttpMethod.GET, "/post/**").authenticated()
            .antMatchers(HttpMethod.POST, "/post/**").authenticated()
            .antMatchers(HttpMethod.PATCH, "/post/**").authenticated()
            .antMatchers(HttpMethod.DELETE, "/post/**").authenticated()

            // health
            .antMatchers(HttpMethod.GET, "/health/**").permitAll()

            .anyRequest().denyAll()
            .and()
            .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter::class.java)
            .build()

    @Bean
    open fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}