package org.jackie35er.dwh.oltp.presentation

import org.jackie35er.dwh.oltp.persistence.*
import org.jackie35er.dwh.oltp.testdata.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    val supplierRepository: org.jackie35er.dwh.oltp.persistence.SupplierRepository,
    val articleRepository: org.jackie35er.dwh.oltp.persistence.ArticleRepository,
    val categoryRepository: org.jackie35er.dwh.oltp.persistence.CategoryRepository,
    val orderRepository: org.jackie35er.dwh.oltp.persistence.OrderRepository,
    val orderDetailsRepository: org.jackie35er.dwh.oltp.persistence.OrderDetailsRepository,
    val firmRepository: org.jackie35er.dwh.oltp.persistence.FirmRepository,
    val customerRepository: org.jackie35er.dwh.oltp.persistence.CustomerRepository,
    val staffRepository: org.jackie35er.dwh.oltp.persistence.StaffRepository
) {


    @PostMapping("/initDB")
    fun initDb() {
        val suppliers = supplierRepository.saveAll(SupplierFactory.createSuppliers())
        val firms = firmRepository.saveAll(FirmFactory.createFirms())
        val categories = categoryRepository.saveAll(CategorySupplier.createCategories())
        val customers = customerRepository.saveAll(CustomerFactory.createCustomers())
        val staff = staffRepository.saveAll(StaffFactory.createStaff())

        val articles = articleRepository.saveAll(org.jackie35er.dwh.oltp.testdata.ArticleFactory.createArticles(suppliers, categories))
        val orders = orderRepository.saveAll(OrderFactory.createOrders(customers, staff,firms))

        orderDetailsRepository.saveAll(OrderDetailsFactory.createOrderDetails(orders, articles))
        println("DB initialized")
    }
}