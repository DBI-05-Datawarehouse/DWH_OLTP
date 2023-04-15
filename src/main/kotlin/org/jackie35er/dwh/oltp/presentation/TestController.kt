package org.jackie35er.dwh.oltp.presentation

import org.jackie35er.dwh.etl.ETLService
import org.jackie35er.dwh.oltp.persistence.*
import org.jackie35er.dwh.oltp.testdata.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
    val supplierRepository: SupplierRepository,
    val articleRepository: ArticleRepository,
    val categoryRepository: CategoryRepository,
    val orderRepository: OrderRepository,
    val orderDetailsRepository: OrderDetailsRepository,
    val firmRepository: FirmRepository,
    val customerRepository: CustomerRepository,
    val staffRepository: StaffRepository,

    val etlService: ETLService,
) {


    @PostMapping("/initDB")
    fun initDb() {
        val suppliers = supplierRepository.saveAll(SupplierFactory.createSuppliers())
        val firms = firmRepository.saveAll(FirmFactory.createFirms())
        val categories = categoryRepository.saveAll(CategorySupplier.createCategories())
        val customers = customerRepository.saveAll(CustomerFactory.createCustomers())
        val staff = staffRepository.saveAll(StaffFactory.createStaff())

        val articles = articleRepository.saveAll(ArticleFactory.createArticles(suppliers, categories))
        val orders = orderRepository.saveAll(OrderFactory.createOrders(customers, staff,firms))

        orderDetailsRepository.saveAll(OrderDetailsFactory.createOrderDetails(orders, articles))
        println("DB initialized")
    }

    @PostMapping("/extract")
    fun extract() {
        etlService.extract()
    }
}