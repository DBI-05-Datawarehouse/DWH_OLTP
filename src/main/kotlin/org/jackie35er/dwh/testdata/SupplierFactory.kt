package org.jackie35er.dwh.testdata

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.jackie35er.dwh.domain.Supplier

object SupplierFactory {

    private val SUPPLIER_CSV = SupplierFactory::class.java.getResource("/mockaroo/supplier.csv")



    fun createSuppliers(): List<Supplier> {
        return csvReader().open(SUPPLIER_CSV.path) {
            readAllWithHeaderAsSequence().map {
                Supplier(
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
