package com.sorsix.bookstoreapi.api

data class CreateBookRequest(
        val title:String = "",
        val authorId:Long = 0,
        val genreId:Long = 0,
        val description:String = ""
)
