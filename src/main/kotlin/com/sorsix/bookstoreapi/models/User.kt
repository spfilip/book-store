package com.sorsix.bookstoreapi.models

import org.hibernate.FetchMode
import org.hibernate.annotations.Fetch
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*


@Entity
@Table(name = "users")
data class User(
        @Id
        @Column(name = "id", unique = true)
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "username")
        private val username: String,

        @Column(name = "password")
        private val password: String,

        @Column(name = "role")
        val role: String = "user",

        @ManyToMany
        @JoinTable(name = "users_books")
        @Fetch(org.hibernate.annotations.FetchMode.JOIN)
        val books:MutableList<Book> = mutableListOf<Book>()


): UserDetails {
        override fun getAuthorities(): Collection<out GrantedAuthority> = arrayListOf<String>(role).map{SimpleGrantedAuthority(it)}

        override fun isEnabled(): Boolean =true

        override fun getUsername(): String = username

        override fun isCredentialsNonExpired(): Boolean = true

        override fun getPassword(): String = password

        override fun isAccountNonExpired(): Boolean = true

        override fun isAccountNonLocked(): Boolean = true

}