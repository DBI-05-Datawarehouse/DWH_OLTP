package org.jackie35er.dwh.oltp.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.ManyToOne
import org.hibernate.Hibernate
import java.io.Serializable
import java.util.*


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

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as OrderDetails

        return order == other.order
                && article == other.article
    }

    override fun hashCode(): Int = Objects.hash(order, article);

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(order = $order , article = $article )"
    }

}

