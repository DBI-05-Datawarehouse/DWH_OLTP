package org.jackie35er.dwh.olap.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class ArticleDim(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val article_nr: Int,
    val supplierNr: Int,
    val firm: String,
    val city: String,
    val country: String,
    val categoryNr: Int,
    val category: String,
)
