package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.Order, Int> {
}