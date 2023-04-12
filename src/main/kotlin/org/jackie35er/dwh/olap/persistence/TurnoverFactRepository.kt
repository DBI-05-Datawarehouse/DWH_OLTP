package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.TurnoverFact
import org.springframework.data.jpa.repository.JpaRepository

interface TurnoverFactRepository : JpaRepository<TurnoverFact, Int>{
}