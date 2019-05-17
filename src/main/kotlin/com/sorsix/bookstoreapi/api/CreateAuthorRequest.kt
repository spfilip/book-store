package com.sorsix.bookstoreapi.api

data class CreateAuthorRequest(
        val name:String = "",
        val age:Int = 0,
        val email:String = ""
)