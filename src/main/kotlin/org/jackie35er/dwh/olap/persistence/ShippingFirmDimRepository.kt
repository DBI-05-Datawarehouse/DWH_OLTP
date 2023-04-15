package org.jackie35er.dwh.olap.persistence

import org.jackie35er.dwh.olap.domain.ShippingFirmDim
import org.springframework.data.jpa.repository.JpaRepository

interface ShippingFirmDimRepository: JpaRepository<ShippingFirmDim, Int>{


    fun findByFirmNr(firmNr: Int): ShippingFirmDim
}