package org.jackie35er.dwh.olap.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.hibernate.validator.constraints.Range

@Entity
data class TimeDim(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    @Range(min = 1, max = 12)
    val month: Int,
    @Range(min = 1, max = 4)
    val quarter: Int,
    val year: Int,
)
