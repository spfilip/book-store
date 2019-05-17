package com.sorsix.bookstoreapi.models

import javax.persistence.*

@Entity
@Table(name = "genres")
data class Genre(
        @Id
        @Column(name = "id", unique = true)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "name")
        val name: String = ""
)