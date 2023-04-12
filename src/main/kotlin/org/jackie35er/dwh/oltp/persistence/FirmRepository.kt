package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.Firm
import org.springframework.data.jpa.repository.JpaRepository

interface FirmRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.Firm, Int> {
}