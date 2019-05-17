package com.sorsix.bookstoreapi.repository

import com.sorsix.bookstoreapi.models.Author
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AuthorRepository :JpaRepository<Author,Long>{

    fun existsByEmail(email:String):Boolean

    fun findAllByName(name:String): List<Author>

    fun getAuthorById(id:Long): Optional<Author>

}