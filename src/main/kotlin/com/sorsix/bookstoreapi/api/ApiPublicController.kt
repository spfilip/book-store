package com.sorsix.bookstoreapi.api

import com.sorsix.bookstoreapi.models.Author
import com.sorsix.bookstoreapi.models.Book
import com.sorsix.bookstoreapi.models.User
import com.sorsix.bookstoreapi.service.AuthorService
import com.sorsix.bookstoreapi.service.BookService
import com.sorsix.bookstoreapi.service.GenreService
import com.sorsix.bookstoreapi.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.nio.file.attribute.GroupPrincipal
import java.security.Principal
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/api/public")
@CrossOrigin("*")
class ApiPublicController(val bookService: BookService,
                          val genreService: GenreService,
                          val authorService: AuthorService,
                          val userService: UserService) {

    @GetMapping("/author/{name}")
    fun getAuthorsByName(@PathVariable name: String): List<Author> = authorService.getAuthorsByName(name)


    @GetMapping("/author/{id}/books")
    fun getBooksByAuthor(@PathVariable id: Long): List<Book> {
        val author = authorService.getAuthorById(id).orElseThrow { Exception("Author not found") }
        return bookService.getBooksByAuthor(author)
    }

    @GetMapping("/genre/{genreName}/books")
    fun getBooksByGenre(@PathVariable genreName: String): List<Book> {
        val genre = genreService.findGenreByName(genreName).orElseThrow { Exception("Genre not found") }
        return bookService.getBooksByGenre(genre)
    }

    @GetMapping("/author/{id}/{genreName}/books")
    fun getBooksByGenreAndAuthor(@PathVariable id: Long, @PathVariable genreName: String): List<Book> {
        val author = authorService.getAuthorById(id).orElseThrow { Exception("Author not found") }
        val genre = genreService.findGenreByName(genreName).orElseThrow { Exception("Genre not found") }

        return bookService.getBooksByAuthorAndGenre(author, genre)
    }

    @PostMapping("/register")
    fun register(@RequestBody createUserRequest: CreateUserRequest): User {

        return userService.createUser(createUserRequest)
    }

    @GetMapping("/login")
    fun logIn(principal: Principal, response: HttpServletResponse,request: HttpServletRequest):Principal = principal
}