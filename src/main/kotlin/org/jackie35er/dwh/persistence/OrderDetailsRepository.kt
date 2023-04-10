package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.OrderDetails
import org.jackie35er.dwh.domain.OrderDetailsPK
import org.springframework.data.jpa.repository.JpaRepository

interface OrderDetailsRepository: JpaRepository<OrderDetails, OrderDetailsPK> {
}