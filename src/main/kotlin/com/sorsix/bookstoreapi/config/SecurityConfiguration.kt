//package com.sorsix.bookstoreapi.config
//
//import org.springframework.context.annotation.Configuration
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//
//@Configuration
//class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//
//    override fun configure(http: HttpSecurity?) {
//        http?.let {
//            it.authorizeRequests()
//                    .antMatchers("/api/**")
//                    .permitAll()
//                    .anyRequest()
//                    .authenticated()
//                    .and()
//        }
//    }
//
//}