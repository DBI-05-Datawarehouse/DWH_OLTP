package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.StaffDim
import org.springframework.data.jpa.repository.JpaRepository

interface StaffDimRepository: JpaRepository<StaffDim, Int> {

    fun findByLastname(lastname: String): StaffDim
}