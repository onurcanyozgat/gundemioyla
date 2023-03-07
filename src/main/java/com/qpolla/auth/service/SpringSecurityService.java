package com.qpolla.auth.service;

import com.qpolla.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityService {
    private final UserService userService;

    @Autowired
    public SpringSecurityService(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // TODO: form login can be changed. enable it.
        http.csrf().disable();
        /* http.csrf().disable().authorizeHttpRequests(
                        (authorize) -> authorize.requestMatchers("/signup/**").
                                        permitAll().requestMatchers("/index").permitAll().requestMatchers(
                                "/users")
                                .hasRole("ADMIN"))
                .formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/users").permitAll())
                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());
        return http.build();*/
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }
}
