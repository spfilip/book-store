package com.sorsix.bookstoreapi.models

import javax.persistence.*


@Entity
@Table(name = "users")
data class User(
        @Id
        @Column(name = "id", unique = true)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "username")
        val username: String = "",

        @Column(name = "password")
        val password: String = "",

        @Column(name = "isAdmin")
        val isAdmin: Boolean = false,

        @ManyToMany
        @Column(name = "books")
        val books:MutableList<Book> = arrayListOf())