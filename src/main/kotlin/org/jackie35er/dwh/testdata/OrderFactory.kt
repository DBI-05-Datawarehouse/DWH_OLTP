package org.jackie35er.dwh.testdata

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.jackie35er.dwh.domain.Customer
import org.jackie35er.dwh.domain.Firm
import org.jackie35er.dwh.domain.Order
import org.jackie35er.dwh.domain.Staff
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object OrderFactory {


    private val ORDER_CSV = OrderFactory::class.java.getResource("/mockaroo/order.csv")


    fun createOrders(customers : List<Customer>, staff: List<Staff>, firm: List<Firm>): List<Order> {
        val pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        return csvReader().open(ORDER_CSV.path) {
            readAllWithHeaderAsSequence().map {
                Order(
                    orderNr = 0,
                    customer = customers.random(),
                    staff = staff.random(),
                    firm = it["firm"]!!,
                    street = it["street"]!!,
                    city = it["city"]!!,
                    region = it["region"]!!,
                    zip = it["zip"]!!,
                    country = it["country"]!!,
                    shippingFirm = firm.random(),
                    orderDate = LocalDate.parse(it["orderDate"]!!,pattern),
                    shippingDate = LocalDate.parse(it["shippingDate"]!!,pattern),
                    shippingCosts = it["shippingCosts"]!!.toDouble(),
                )
            }.toList()
        }
    }
}