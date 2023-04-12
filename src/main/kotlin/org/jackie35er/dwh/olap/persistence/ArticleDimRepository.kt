package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.ArticleDim
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleDimRepository: JpaRepository<ArticleDim,Int> {
}