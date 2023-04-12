package org.jackie35er.dwh.oltp.persistence

import org.jackie35er.dwh.oltp.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<org.jackie35er.dwh.oltp.domain.Article,Int> {
}