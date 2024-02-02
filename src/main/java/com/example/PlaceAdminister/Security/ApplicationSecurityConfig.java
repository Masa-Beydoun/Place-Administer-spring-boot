//package com.example.PlaceAdminister.Security;
//
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class ApplicationSecurityConfig  extends WebSecurityConfiguration {
//
//
//
//    //    protected void configure(HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .httpBasic();
////    }
////
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .inMemoryAuthentication()
////                .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
////    }
////
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//}
