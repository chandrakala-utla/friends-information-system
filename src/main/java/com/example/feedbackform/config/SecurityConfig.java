package com.example.feedbackform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                .requestMatchers(
                        "/",
                        "/save",
                        "/success"
                ).permitAll()

                .anyRequest().authenticated()
            )

            .formLogin(form -> form
                    .defaultSuccessUrl("/friends", true)
                    .permitAll()
            )

            .logout(logout -> logout
                    .logoutSuccessUrl("/")
                    .permitAll()
            );

        return http.build();
    }
}