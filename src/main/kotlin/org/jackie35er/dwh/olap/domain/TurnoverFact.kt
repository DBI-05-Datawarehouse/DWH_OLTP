package org.jackie35er.dwh.olap.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
data class TurnoverFact(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @ManyToOne
    val articleDim: ArticleDim,

    @ManyToOne
    val customerDim: CustomerDim,

    @ManyToOne
    val shippingFirmDim: ShippingFirmDim,

    @ManyToOne
    val staffDim: StaffDim,

    @ManyToOne
    val timeDim: TimeDim,

    var turnover: Double,
) {
    fun getTurnoverKey(): TurnoverKey {
        return TurnoverKey(
            articleDim.id,
            customerDim.id,
            timeDim.id,
        )
    }
}

data class TurnoverKey(
    val articleDim: Int,
    val customerDim: Int,
    val timeDim: Int,
)