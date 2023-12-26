package com.NextLeap.Restaurant_Management_Platform_Project.Configurations;

import com.NextLeap.Restaurant_Management_Platform_Project.Filters.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final AuthenticationEntryPoint unauthorizedHandler;

    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // define the public and protected endpoints

         http.csrf(AbstractHttpConfigurer::disable)
                 .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                 .authorizeHttpRequests(auth ->{
                             auth.requestMatchers("restaurant-platform/v1/",
                                     "restaurant-platform/v1/register",
                                     "restaurant-platform/v1/authenticate").permitAll()
                                 .requestMatchers(HttpMethod.GET, "restaurant-platform/v1/restaurants/**",
                                         "restaurant-platform/v1/cuisines/**","restaurant-platform/v1/home",
                                         "restaurant-platform/v1/search/**").permitAll()
                                 .anyRequest().authenticated();
                 })
                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .authenticationProvider(authenticationProvider)
                 .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
