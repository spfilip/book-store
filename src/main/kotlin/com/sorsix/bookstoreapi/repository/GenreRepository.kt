package com.sorsix.bookstoreapi.repository

import com.sorsix.bookstoreapi.models.Genre
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GenreRepository : JpaRepository<Genre, Long> {

    fun findGenreByName(name: String): Optional<Genre>

    fun existsByName(name: String): Boolean


}