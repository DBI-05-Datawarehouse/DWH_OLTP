package org.jackie35er.dwh.oltp.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Supplier(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val supplierNr: Int,
    val firm: String,
    val contact: String,
    val position: String,
    val street: String,
    val city: String,
    val region: String,
    val zip: String,
    val country: String,
    val phone: String,
    val fax: String,
) {
}