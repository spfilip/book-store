package com.sorsix.bookstoreapi.service

import com.sorsix.bookstoreapi.models.Author
import com.sorsix.bookstoreapi.models.Book
import com.sorsix.bookstoreapi.models.Genre
import com.sorsix.bookstoreapi.repository.AuthorRepository
import com.sorsix.bookstoreapi.repository.BookRepository
import com.sorsix.bookstoreapi.repository.GenreRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BookService(val bookRepository: BookRepository,
                  val genreRepository: GenreRepository,
                  val authorRepository: AuthorRepository) {

    fun createBook(title: String, genreId: Long, authorId: Long): Optional<Book> {
        val genre = genreRepository.findById(genreId).orElseThrow { Exception("Genre not found") }
        val author = authorRepository.findById(authorId).orElseThrow { Exception("Author not found") }

        return if (bookRepository.existsByTitleAndAuthor(title, author)) {
            Optional.empty()
        } else {
            val book = Book(title = title, author = author, genre = genre)
            Optional.of(bookRepository.save(book))
        }
    }

    fun getBooksByAuthor(author: Author): List<Book> = bookRepository.findAllByAuthor(author)

    fun getBooksByTitle(title: String): List<Book> = bookRepository.findAllByTitle(title)

    fun getBooksByGenre(genre: Genre): List<Book> = bookRepository.findAllByGenre(genre)

    fun getBookById(id: Long): Optional<Book> = bookRepository.findById(id)

    fun getBooksByAuthorAndGenre(author: Author, genre: Genre): List<Book> = bookRepository.findAllByAuthorAndGenre(author, genre)
}