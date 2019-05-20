package com.sorsix.bookstoreapi.service

import com.sorsix.bookstoreapi.models.Book
import com.sorsix.bookstoreapi.models.User
import com.sorsix.bookstoreapi.repository.BookRepository
import com.sorsix.bookstoreapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional


@Service
class UserService(val userRepository: UserRepository,
                  val bookRepository: BookRepository) {

    fun createUser(username: String, password: String): Optional<User> {
        return if (userRepository.existsByUsername(username)) {
            Optional.empty()
        } else {
            val user = User(username = username, password = password)
            Optional.of(userRepository.save(user))
        }
    }

    @Transactional
    fun addBookToUser(id:Long,bookId:Long):Boolean{
       val book =  bookRepository.findById(bookId).orElseThrow{Exception("book not found")}

       return userRepository.findById(id).orElseThrow{Exception("User not found")}.books.add(book)

    }

    fun getUserBooks(id:Long):List<Book>{
      return userRepository.findById(id).orElseThrow{Exception("User not found")}.books
    }


}
