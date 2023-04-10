package org.jackie35er.dwh.persistence

import org.jackie35er.dwh.domain.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<Article,Int> {
}