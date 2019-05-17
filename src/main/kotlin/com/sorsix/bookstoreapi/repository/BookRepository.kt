package com.sorsix.bookstoreapi.repository

import com.sorsix.bookstoreapi.models.Author
import com.sorsix.bookstoreapi.models.Book
import com.sorsix.bookstoreapi.models.Genre
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository : JpaRepository<Book, Long>{
    fun existsByTitleAndAuthor(title:String,author: Author):Boolean
    fun findAllByAuthor(author:Author): List<Book>
    fun findAllByTitle(title:String): List<Book>
    fun findAllByGenre(genre: Genre): List<Book>
    fun findAllByAuthorAndGenre(author:Author,genre: Genre):List<Book>

}