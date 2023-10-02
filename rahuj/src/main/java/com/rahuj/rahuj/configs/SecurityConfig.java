package com.rahuj.rahuj.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;


import com.rahuj.rahuj.services.ClientService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

  private final ClientService clientService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {

    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(clientService);
    authProvider.setPasswordEncoder(bCryptPasswordEncoder);

    return authProvider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception {
    MvcRequestMatcher.Builder mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);
    http.authorizeHttpRequests((requests) -> requests
        .requestMatchers(mvcMatcherBuilder.pattern("/api/**")).authenticated()
        .requestMatchers(mvcMatcherBuilder.pattern("/auth/**")).permitAll()
        .requestMatchers(toH2Console()).permitAll()
        .anyRequest().authenticated())
        .csrf(AbstractHttpConfigurer::disable)
        .csrf(csrf -> csrf
            .ignoringRequestMatchers(toH2Console())
            .disable())
        .headers(headers -> headers.frameOptions(FrameOptionsConfig::disable));

    http.authenticationProvider(authenticationProvider());

    return http.build();
  }
}
