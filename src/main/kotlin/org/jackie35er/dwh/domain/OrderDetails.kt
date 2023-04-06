package org.jackie35er.dwh.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class OrderDetails(
    @Id
    @ManyToOne
    val order: Order,

    @Id
    @ManyToOne
    val article: Article,
    val singlePrice: Double,
    val quantity: Int,
    val discount: Double,

)
