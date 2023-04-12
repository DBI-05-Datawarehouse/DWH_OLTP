package org.jackie35er.dwh.oltp.domain

import jakarta.persistence.*

@Entity
data class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val articleNr: Int,

    @ManyToOne
    val supplier: Supplier,

    @ManyToOne
    val category: Category,
    val name: String,
    val supplyUnit: String,
    val price: Double,
    val stock: Int,
    val orderUnit: String,
    val minStock: Int,
    val discontinued: Boolean,
)
