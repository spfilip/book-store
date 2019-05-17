package com.sorsix.bookstoreapi.service

import com.sorsix.bookstoreapi.models.Author
import com.sorsix.bookstoreapi.repository.AuthorRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional


@Service
class AuthorService (val repository: AuthorRepository){

    @Transactional
    fun createAuthor(name:String,age:Int,email:String): Optional<Author> {
        if (repository.existsByEmail(email)) {
            return Optional.empty()
        } else {
            val author = Author(name = name,age = age,email = email)
            return Optional.of(repository.save(author))
        }
    }

    fun getAll(): List<Author> = repository.findAll()

    fun getAuthorsByName(name:String): List<Author> = repository.findAllByName(name)

    fun getAuthorById(id:Long) : Optional<Author> = repository.getAuthorById(id)
}