package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.Customer, Int> {
}