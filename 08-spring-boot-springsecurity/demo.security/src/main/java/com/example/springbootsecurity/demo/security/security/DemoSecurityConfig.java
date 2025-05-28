package com.example.springbootsecurity.demo.security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

        // create bean for in memory user details
        UserDetails john = User.withUsername("john").password("{noop}test123").roles("employee").build();

        UserDetails marry = User.withUsername("marry").password("{noop}test123").roles("employee", "manager").build();

        UserDetails susan = User.withUsername("susan").password("{noop}test123").roles("employee", "manager", "admin").build();

        return new InMemoryUserDetailsManager(john, marry, susan);

    }

    // This functions deals with authentication and what data can each user access

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // this checks to make sure any request to the app is authenticated
        http.authorizeHttpRequests(configurer -> configurer

                        // this restricts users to access there level of info
                        .requestMatchers("/").hasRole("employee")
                        .requestMatchers("/leaders/**").hasRole("manager")
                        .requestMatchers("/admin/**").hasRole("admin")

                        // this checks to make sure any request to the app is authenticated
                        .anyRequest().authenticated())

                .formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()

                ).logout(logout -> logout.permitAll()

                )
                .exceptionHandling(exception -> exception.accessDeniedPage("/access-denied"));

        return http.build();
    }




}
