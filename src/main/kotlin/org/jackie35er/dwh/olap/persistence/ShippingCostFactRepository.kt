package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.ShippingCostFact
import org.springframework.data.jpa.repository.JpaRepository

interface ShippingCostFactRepository : JpaRepository<ShippingCostFact,Int>{
}