package org.jackie35er.dwh.oltp.testdata

import org.jackie35er.dwh.oltp.domain.Article
import org.jackie35er.dwh.oltp.domain.Order
import org.jackie35er.dwh.oltp.domain.OrderDetails
import java.lang.Math.round
import kotlin.random.Random

object OrderDetailsFactory {

    fun createOrderDetails(orders: List<org.jackie35er.dwh.oltp.domain.Order>, articles: List<org.jackie35er.dwh.oltp.domain.Article>): List<org.jackie35er.dwh.oltp.domain.OrderDetails> {

        val orderDetails = mutableListOf<org.jackie35er.dwh.oltp.domain.OrderDetails>()

        for (i in 1..900) {
            val order = orders.random()
            val article = articles.random()

            orderDetails.add(
                org.jackie35er.dwh.oltp.domain.OrderDetails(
                    order = order,
                    article = article,
                    singlePrice = article.price,
                    quantity = (1..10).random(),
                    discount = (200..1000).random() / 10.0
                )
            )

        }

        return orderDetails
    }
}