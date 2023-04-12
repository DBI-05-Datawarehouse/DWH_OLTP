package org.jackie35er.dwh.oltp.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderNr: Int,

    @ManyToOne
    val customer: org.jackie35er.dwh.oltp.domain.Customer,

    @ManyToOne
    val staff: org.jackie35er.dwh.oltp.domain.Staff,
    val firm: String,
    val street: String,
    val city: String,
    val region: String,
    val zip: String,
    val country: String,

    @ManyToOne
    val shippingFirm: org.jackie35er.dwh.oltp.domain.Firm,
    val orderDate: LocalDate,
    val shippingDate: LocalDate,
    val shippingCosts: Double,
)
