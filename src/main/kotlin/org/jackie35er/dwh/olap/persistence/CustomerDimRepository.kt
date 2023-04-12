package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.CustomerDim
import org.springframework.data.jpa.repository.JpaRepository


interface CustomerDimRepository: JpaRepository<CustomerDim,Int> {
}