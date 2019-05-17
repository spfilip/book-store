package com.sorsix.bookstoreapi.api

data class CreateUserRequest(
        val username:String = "",
        val password:String = ""
)