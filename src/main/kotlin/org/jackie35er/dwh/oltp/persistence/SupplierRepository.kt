package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.Supplier
import org.springframework.data.jpa.repository.JpaRepository

interface SupplierRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.Supplier, Int>  {
}