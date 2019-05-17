package com.sorsix.bookstoreapi.service

import com.sorsix.bookstoreapi.models.User
import com.sorsix.bookstoreapi.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*


@Service
class UserService(val repository: UserRepository) {

    fun createUser(username: String, password: String): Optional<User> {
       return if (repository.existsByUsername(username)) {
             Optional.empty()
        } else {
            val user = User(username = username,password = password)
             Optional.of(repository.save(user))
        }
    }

}
