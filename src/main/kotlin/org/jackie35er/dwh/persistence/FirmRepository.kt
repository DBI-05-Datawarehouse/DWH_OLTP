package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.Firm
import org.springframework.data.jpa.repository.JpaRepository

interface FirmRepository: JpaRepository<Firm, Int> {
}