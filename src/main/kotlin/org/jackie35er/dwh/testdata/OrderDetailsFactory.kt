package org.jackie35er.dwh.testdata

import org.jackie35er.dwh.domain.Article
import org.jackie35er.dwh.domain.Order
import org.jackie35er.dwh.domain.OrderDetails
import java.lang.Math.round
import kotlin.random.Random

object OrderDetailsFactory {

    fun createOrderDetails(orders: List<Order>, articles: List<Article>): List<OrderDetails> {

        val orderDetails = mutableListOf<OrderDetails>()

        for (i in 1..900) {
            val order = orders.random()
            val article = articles.random()

            orderDetails.add(
                OrderDetails(
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