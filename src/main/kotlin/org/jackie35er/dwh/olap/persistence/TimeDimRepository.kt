package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.TimeDim
import org.springframework.data.jpa.repository.JpaRepository

interface TimeDimRepository: JpaRepository<TimeDim, Int> {

    fun findByMonthAndYear(month: Int, year : Int ): TimeDim
}