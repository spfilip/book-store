package com.sorsix.bookstoreapi.security

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomLogoutSuccessHandler: SimpleUrlLogoutSuccessHandler(),LogoutSuccessHandler {


    override fun onLogoutSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
        super.onLogoutSuccess(request, response, authentication)
    }
}