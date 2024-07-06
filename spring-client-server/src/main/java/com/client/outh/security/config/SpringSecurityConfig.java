package com.client.outh.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
// Importamos método estático withDefaults
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.authorizeHttpRequests(authHttp -> authHttp
        .requestMatchers(HttpMethod.GET, "/authorized").permitAll()
        .requestMatchers(HttpMethod.GET, "/listaMensaje").hasAnyAuthority("SCOPE_read", "SCOPE_write")
        .requestMatchers(HttpMethod.POST, "/crear").hasAuthority("SCOPE_write")
        .anyRequest().authenticated())
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        // Login de ouath2
        .oauth2Login(login -> login.loginPage("/oauth2/authorization/client-app"))
        // Cliente
        .oauth2Client(client -> withDefaults())
        .oauth2ResourceServer(resourceServer -> resourceServer.jwt(withDefaults()))
        .build();
  }
  
}
