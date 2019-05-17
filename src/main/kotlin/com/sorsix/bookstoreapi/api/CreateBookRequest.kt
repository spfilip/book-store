package com.sorsix.bookstoreapi.api

import com.sorsix.bookstoreapi.models.Author
import com.sorsix.bookstoreapi.models.Genre

data class CreateBookRequest(
        val title:String = "",
        val author: Author = Author(),
        val genre:Genre = Genre(),
        val description:String = ""
)
