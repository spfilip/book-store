package com.sorsix.bookstoreapi.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
class SecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http?.let {
            it.authorizeRequests()
                    .antMatchers("/api/public/register","/api/login")
                    .permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .logout().permitAll().logoutRequestMatcher(AntPathRequestMatcher("/api/logout","POST"))
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessHandler(logoutSucessHandler())
                    .and()
                    .httpBasic()
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                    .and().csrf().disable()


        }
    }
    @Bean
    fun logoutSucessHandler():LogoutSuccessHandler=CustomLogoutSuccessHandler()

}