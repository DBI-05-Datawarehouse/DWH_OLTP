package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.TurnoverFact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TurnoverFactRepository : JpaRepository<TurnoverFact, Int>{



}