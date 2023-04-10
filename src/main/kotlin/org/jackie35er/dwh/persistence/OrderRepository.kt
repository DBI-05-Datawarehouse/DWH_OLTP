package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Int> {
}