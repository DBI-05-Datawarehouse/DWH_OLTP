package org.jackie35er.dwh.etl

import org.jackie35er.dwh.olap.domain.*
import org.jackie35er.dwh.olap.persistence.*
import org.jackie35er.dwh.oltp.persistence.*
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ETLService(
    val articleRepository: ArticleRepository,
    val articleDimRepository: ArticleDimRepository,

    val customerRepository: CustomerRepository,
    val customerDimRepository: CustomerDimRepository,

    val firmRepository: FirmRepository,
    val shippingFirmDimRepository: ShippingFirmDimRepository,

    val staffRepository: StaffRepository,
    val staffDimRepository: StaffDimRepository,

    val orderRepository: OrderRepository,
    val timeDimRepository: TimeDimRepository,

    val orderDetailsRepository: OrderDetailsRepository,
    val turnoverFactRepository: TurnoverFactRepository,

    val shippingCostFactRepository: ShippingCostFactRepository,
) {


    fun extractArticles() {
        val articles = articleRepository.findAll()

        val articleDim = articles.map {
            ArticleDim(
                0,
                it.articleNr,
                it.name,
                it.supplier.supplierNr,
                it.supplier.firm,
                it.supplier.city,
                it.supplier.country,
                it.category.categoryNr,
                it.category.name
            )
        }
        articleDimRepository.saveAll(articleDim)
    }

    fun extractCustomers() {
        val customers = customerRepository.findAll()

        val customerDim = customers.map {
            CustomerDim(
                0,
                it.customerNr,
                it.firm,
                it.city,
                it.country
            )
        }

        customerDimRepository.saveAll(customerDim)
    }

    fun extractShippingFirms() {
        val shippingFirms = firmRepository.findAll()

        val shippingFirmDim = shippingFirms.map {
            ShippingFirmDim(
                0,
                it.firmNr,
                it.name,
            )
        }

        shippingFirmDimRepository.saveAll(shippingFirmDim)
    }

    fun extractStaff() {
        val staff = staffRepository.findAll()

        val staffDim = staff.map {
            StaffDim(
                0,
                it.lastName,
                it.firstName,
                it.position,
            )
        }

        staffDimRepository.saveAll(staffDim)
    }

    fun extractTimeDim() {
        val orders = orderRepository.findAll()

        val timeDim = orders.map { it.orderDate }
            .distinctBy { it.monthValue to it.year }
            .map {
                TimeDim(
                    0,
                    it.monthValue,
                    it.monthValue / 3,
                    it.year,
                )
            }

        timeDimRepository.saveAll(timeDim)
    }

    fun extractTurnoverFact() {
        val orderDetails = orderDetailsRepository.findAll()


        val turnoverFact = orderDetails.map {
            TurnoverFact(
                0,
                articleDimRepository.findById(it.article.articleNr).get(),
                customerDimRepository.findById(it.order.customer.customerNr).get(),
                shippingFirmDimRepository.findByFirmNr(it.order.shippingFirm.firmNr),
                staffDimRepository.findByLastname(it.order.staff.lastName),
                timeDimRepository.findByMonthAndYear(it.order.orderDate.monthValue, it.order.orderDate.year),
                it.singlePrice * it.quantity - (it.discount / 100) * it.singlePrice * it.quantity
            )
        }.groupBy { it.getTurnoverKey() }
            .map { entry ->
                val turnover = entry.value.map { it.turnover }.sum()
                entry.value.first().copy(turnover = turnover)
            }
        turnoverFactRepository.saveAll(turnoverFact)

    }

    fun extractShippingCostFact() {
        val orders = orderRepository.findAll()

        val shippingCostFacts = orders.map {
            ShippingCostFact(
                0,
                customerDimRepository.findById(it.customer.customerNr).get(),
                staffDimRepository.findByLastname(it.staff.lastName),
                shippingFirmDimRepository.findByFirmNr(it.shippingFirm.firmNr),
                timeDimRepository.findByMonthAndYear(it.orderDate.monthValue, it.orderDate.year),
                it.shippingCosts
            )
        }.groupBy { it.getShippingCostKey() }
            .map { entry ->
                val shippingCosts = entry.value.map { it.shippingCost }.sum()
                entry.value.first().copy(shippingCost = shippingCosts)
            }

        shippingCostFactRepository.saveAll(shippingCostFacts)
    }

    fun extract() {
        extractArticles()
        extractCustomers()
        extractShippingFirms()
        extractStaff()
        extractTimeDim()
        extractTurnoverFact()
        extractShippingCostFact()
    }
}