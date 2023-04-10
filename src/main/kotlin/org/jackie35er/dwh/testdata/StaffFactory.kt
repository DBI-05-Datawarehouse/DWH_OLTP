package org.jackie35er.dwh.testdata

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.jackie35er.dwh.domain.Staff
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object StaffFactory {

    private val STAFF_CSV = StaffFactory::class.java.getResource("/mockaroo/staff.csv")


    private val positions = {
        val positions = mutableListOf<String>()
        for (i in 1..10) {
            positions.add("Position $i")
        }
        positions
    }

    private val remarks = {
        val remarks = mutableListOf<String>()
        for (i in 1..10) {
            remarks.add("Remark $i")
        }
        remarks
    }

    fun createStaff(): List<Staff> {
        val pattern = DateTimeFormatter.ofPattern("M/d/yyyy")
        return csvReader().open(STAFF_CSV.path) {
            readAllWithHeaderAsSequence().map {
                Staff(
                    staffNr = 0,
                    lastName = it["last_name"]!!,
                    firstName = it["first_name"]!!,
                    position = positions().random(),
                    birthDate = LocalDate.parse(it["birthDate"]!!,pattern),
                    hireDate = LocalDate.parse(it["hireDate"]!!,pattern),
                    street = it["street"]!!,
                    city = it["city"]!!,
                    region = it["region"]!!,
                    zip = it["zip"]!!,
                    country = it["country"]!!,
                    phonePrivate = it["phonePrivate"]!!,
                    phoneOffice = it["phoneOffice"]!!,
                    remark = remarks().random(),
                    boss = it["boss"]!!,
                )
            }.toList()
        }
    }

}