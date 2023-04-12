package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.Staff
import org.springframework.data.jpa.repository.JpaRepository

interface StaffRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.Staff,Int> {
}