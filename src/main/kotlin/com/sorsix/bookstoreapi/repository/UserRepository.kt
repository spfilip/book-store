package com.sorsix.bookstoreapi.repository

import com.sorsix.bookstoreapi.models.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, Long> {

    fun existsByUsername(username: String): Boolean

    fun findByUsername(username: String): Optional<User>

}