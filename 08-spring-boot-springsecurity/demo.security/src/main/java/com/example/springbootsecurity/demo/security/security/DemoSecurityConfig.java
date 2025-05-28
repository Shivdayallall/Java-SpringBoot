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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // this checks to make sure any request to the app is authenticated
        http.authorizeHttpRequests(configurer -> configurer.anyRequest().authenticated())

                .formLogin(form -> form.loginPage("/showMyLoginPage").loginProcessingUrl("/authenticateTheUser").permitAll()

                ).logout(logout -> logout.permitAll()

                );

        return http.build();
    }




}
