package org.jackie35er.dwh.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDate

@Entity
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderNr: Int,

    @ManyToOne
    val customer: Customer,

    @ManyToOne
    val staff: Staff,
    val firm: String,
    val street: String,
    val city: String,
    val region: String,
    val zip: String,
    val country: String,

    @ManyToOne
    val shippingFirm: Firm,
    val orderDate: LocalDate,
    val shippingDate: LocalDate,
    val shippingCosts: Double,
)
