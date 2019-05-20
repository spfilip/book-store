package com.sorsix.bookstoreapi.api

import com.sorsix.bookstoreapi.models.Author
import com.sorsix.bookstoreapi.models.Book
import com.sorsix.bookstoreapi.models.Genre
import com.sorsix.bookstoreapi.service.AuthorService
import com.sorsix.bookstoreapi.service.BookService
import com.sorsix.bookstoreapi.service.GenreService
import com.sorsix.bookstoreapi.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin("* ")
@RequestMapping("/api")
class ApiController(val bookService: BookService,
                    val genreService: GenreService,
                    val authorService: AuthorService,
                    val userService: UserService) {

    @PostMapping("/genre/add/{name}")
    fun addGenre(@PathVariable name: String): ResponseEntity<Genre> = ResponseEntity.ok(genreService.createGenre(name).orElseThrow { Exception("Invalid genre") })

    @PostMapping("/author/add")
    fun addAuthor(@RequestBody createAuthorRequest: CreateAuthorRequest): ResponseEntity<Author> = ResponseEntity.ok(authorService.createAuthor(name = createAuthorRequest.name, age = createAuthorRequest.age, email = createAuthorRequest.email).orElseThrow { Exception("Invalid author") })

    @PostMapping("/book/add")
    fun addBook(@RequestBody createBookRequest: CreateBookRequest):Book {
        return bookService.createBook(title = createBookRequest.title, genreId = createBookRequest.genreId, authorId = createBookRequest.authorId).orElseThrow{Exception("Failed to create book")}
    }

    @PostMapping("/register")
    fun registerUser(@RequestBody createUserRequest: CreateUserRequest) = userService.createUser(createUserRequest.username,createUserRequest.password)

    
    @PostMapping("user/{userId}/book/{bookId}")
    fun addBookToUser(@PathVariable userId: Long,@PathVariable bookId: Long): Boolean = userService.addBookToUser(userId,bookId)


    @GetMapping("user/{userId}/books")
    fun getMyBooks(@PathVariable userId:Long):List<Book> = userService.getUserBooks(userId)



}