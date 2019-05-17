package com.sorsix.bookstoreapi.service

import com.sorsix.bookstoreapi.models.Author
import com.sorsix.bookstoreapi.models.Book
import com.sorsix.bookstoreapi.models.Genre
import com.sorsix.bookstoreapi.repository.BookRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(val repository: BookRepository) {

    fun createBook(title: String, genre: Genre, author: Author): Optional<Book> {
        if (repository.existsByTitleAndAuthor(title, author)) {
            return Optional.empty()
        } else {
            val book = Book(title = title, author = author, genre = genre)
            return Optional.of(repository.save(book))
        }
    }

    fun getBooksByAuthor(author: Author): List<Book> = repository.findAllByAuthor(author)

    fun getBooksByTitle(title: String): List<Book> = repository.findAllByTitle(title)

    fun getBooksByGenre(genre: Genre): List<Book> = repository.findAllByGenre(genre)

    fun getBookById(id:Long): Optional<Book> = repository.findById(id)

    fun getBooksByAuthorAndGenre(author: Author,genre: Genre): List<Book> = repository.findAllByAuthorAndGenre(author,genre)
}