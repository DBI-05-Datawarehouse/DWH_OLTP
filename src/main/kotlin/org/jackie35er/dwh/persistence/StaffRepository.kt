package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.Staff
import org.springframework.data.jpa.repository.JpaRepository

interface StaffRepository: JpaRepository<Staff,Int> {
}