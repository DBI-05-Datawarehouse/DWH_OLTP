package org.jackie35er.dwh.testdata

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.jackie35er.dwh.domain.Customer

object CustomerFactory {

    private val CUSTOMER_CSV = SupplierFactory::class.java.getResource("/mockaroo/customer.csv")


    fun createCustomers(): List<Customer> {
        return csvReader().open(CUSTOMER_CSV.path) {
            readAllWithHeaderAsSequence().map {
                Customer(
                    customerNr = 0,
                    firm = it["firm"]!!,
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