package com.sorsix.bookstoreapi.service

import com.sorsix.bookstoreapi.models.Genre
import com.sorsix.bookstoreapi.repository.GenreRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class GenreService(val repository: GenreRepository) {

    fun createGenre(name: String): Optional<Genre> {
        if (repository.existsByName(name)) {
            return Optional.empty()
        } else {
            val genre = Genre(name = name)
         return Optional.of(repository.save(genre))
        }
    }

    fun getAll():List<Genre> = repository.findAll()

    fun findGenreByName(name:String):Optional<Genre> = repository.findGenreByName(name)
}