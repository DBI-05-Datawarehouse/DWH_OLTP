package org.jackie35er.dwh.olap.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id


@Entity
data class StaffDim(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Int,

    private val lastname: String,
    private val firstname: String,
    private val position: String,
)