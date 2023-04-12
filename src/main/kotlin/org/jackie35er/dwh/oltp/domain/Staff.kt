package org.jackie35er.dwh.oltp.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDate

@Entity
data class Staff(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val staffNr: Int,
    val lastName: String,
    val firstName: String,
    val position: String,
    val birthDate: LocalDate,
    val hireDate: LocalDate,
    val street: String,
    val city: String,
    val region: String,
    val zip: String,
    val country: String,
    val phonePrivate: String,
    val phoneOffice: String,
    val remark: String,
    val boss: String
)
