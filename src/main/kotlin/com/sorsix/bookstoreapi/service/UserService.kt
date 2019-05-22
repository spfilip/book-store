package com.sorsix.bookstoreapi.service

import com.sorsix.bookstoreapi.api.CreateUserRequest
import com.sorsix.bookstoreapi.models.Book
import com.sorsix.bookstoreapi.models.User
import com.sorsix.bookstoreapi.repository.BookRepository
import com.sorsix.bookstoreapi.repository.UserRepository
import com.sorsix.bookstoreapi.security.PasswordEncoderConf
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class UserService(val userRepository: UserRepository,
                  val bookRepository: BookRepository,
                  val encoder: PasswordEncoderConf) : UserDetailsService {


    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUsername(username).orElseThrow { Exception("username not found") }
    }


    fun createUser(createUserRequest: CreateUserRequest): User = userRepository.save(User(username = createUserRequest.username, password = encoder.passwordEncoder().encode(createUserRequest.password)))

    @Transactional
    fun addBookToUser(id: Long, bookId: Long): Boolean {
        val book = bookRepository.findById(bookId).orElseThrow { Exception("book not found") }

        return userRepository.findById(id).orElseThrow { Exception("User not found") }.books.add(book)

    }

    fun getUserBooks(id: Long): List<Book> {
        return userRepository.findById(id).orElseThrow { Exception("User not found") }.books
    }


}
