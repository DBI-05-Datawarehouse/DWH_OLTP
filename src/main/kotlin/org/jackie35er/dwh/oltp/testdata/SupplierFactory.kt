package org.jackie35er.dwh.oltp.testdata

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.jackie35er.dwh.oltp.domain.Supplier

object SupplierFactory {

    private val SUPPLIER_CSV = SupplierFactory::class.java.getResource("/mockaroo/supplier.csv")

    fun createSuppliers(): List<org.jackie35er.dwh.oltp.domain.Supplier> {
        return csvReader().open(SUPPLIER_CSV.path) {
            readAllWithHeaderAsSequence().map {
                org.jackie35er.dwh.oltp.domain.Supplier(
                    supplierNr = 0,
                    firm = it["name"]!!,
                    contact = it["contact"]!!,
                    position = it["position"]!!,
                    street = it["street"]!!,
                    city = it["city"]!!,
                    region = it["region"]!!,
                    zip = it["zip"]!!,
                    country = it["country"]!!,
                    phone = it["phone"]!!,
                    fax = it["fax"]!!,
                )
            }.toList()
        }
    }
}
