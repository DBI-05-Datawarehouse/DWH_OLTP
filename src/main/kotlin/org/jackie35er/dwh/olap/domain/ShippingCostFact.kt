package org.jackie35er.dwh.olap.domain

import jakarta.persistence.*


@Entity
data class ShippingCostFact(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @ManyToOne
    val customerDim: CustomerDim,

    @ManyToOne
    val staffDim: StaffDim,

    @ManyToOne
    val shippingFirmDim: ShippingFirmDim,

    @ManyToOne
    val timeDim: TimeDim
)