package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.OrderDetails
import org.jackie35er.dwh.oltp.domain.OrderDetailsPK
import org.springframework.data.jpa.repository.JpaRepository

interface OrderDetailsRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.OrderDetails, org.jackie35er.dwh.oltp.domain.OrderDetailsPK> {
}