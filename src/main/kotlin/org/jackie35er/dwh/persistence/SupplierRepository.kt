package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.Supplier
import org.springframework.data.jpa.repository.JpaRepository

interface SupplierRepository: JpaRepository<Supplier, Int>  {
}