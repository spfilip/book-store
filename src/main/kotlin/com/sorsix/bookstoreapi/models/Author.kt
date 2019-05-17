package com.sorsix.bookstoreapi.models

import javax.persistence.*


@Entity
@Table(name = "authors")
data class Author(
        @Id
        @Column(name = "id", unique = true)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "name")
        val name: String = "",

        @Column(name = "age")
        val age: Int = 0,

        @Column(name = "email")
        val email: String = ""
)