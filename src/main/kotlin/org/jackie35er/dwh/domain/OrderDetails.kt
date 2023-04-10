package org.jackie35er.dwh.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.ManyToOne
import java.io.Serializable


data class OrderDetailsPK(
    val order: Int,
    val article: Int,
) : Serializable {

    @Suppress("unused")//used by JPA
    constructor() : this(0, 0)
}

@Entity
@IdClass(OrderDetailsPK::class)
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

