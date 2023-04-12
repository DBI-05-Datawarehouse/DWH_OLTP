package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.Category, Int> {
}