package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Int> {
}