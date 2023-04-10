package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository: JpaRepository<Category, Int> {
}