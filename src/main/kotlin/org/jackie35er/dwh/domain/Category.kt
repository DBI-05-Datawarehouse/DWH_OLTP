package org.jackie35er.dwh.domain

import jakarta.persistence.*

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoryNr: Int,

    val name: String,
    @Column(columnDefinition = "TEXT")
    val description: String,


)
