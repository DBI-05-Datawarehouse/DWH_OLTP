package org.jackie35er.dwh.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Firm(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val firmNr: Int,
    val name: String,
)
