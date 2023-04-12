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

    val turnover: Double,
)
