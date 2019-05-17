package com.sorsix.bookstoreapi.models

import javax.persistence.*

@Entity
@Table(name = "books")
data class Book(
        @Id
        @Column(name = "id", unique = true)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "title")
        val title: String = "",

        @Column(name = "description")
        val description: String = "",

        @JoinColumn(name = "author")
        @ManyToOne
        val author: Author = Author(),

        @JoinColumn(name = "genre")
        @ManyToOne
        val genre: Genre = Genre(),

        @Column(name = "content",columnDefinition = "TEXT")
        val content:String = "",

        @Column(name = "rating")
        val rating:Float = 0.0f
)
