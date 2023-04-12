package org.jackie35er.dwh.oltp.testdata

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.jackie35er.dwh.oltp.domain.Article
import org.jackie35er.dwh.oltp.domain.Category
import org.jackie35er.dwh.oltp.domain.Supplier

object ArticleFactory {
    private val ARTICLE_CSV = org.jackie35er.dwh.oltp.testdata.SupplierFactory::class.java.getResource("/mockaroo/Article.csv")

    private val units = {
        val units = mutableListOf<String>()
        for (i in 1..10) {
            units.add("Unit $i")
        }
        units
    }

    fun createArticles(suppliers: List<org.jackie35er.dwh.oltp.domain.Supplier>, categories: List<org.jackie35er.dwh.oltp.domain.Category>): List<org.jackie35er.dwh.oltp.domain.Article> {
        return csvReader().open(org.jackie35er.dwh.oltp.testdata.ArticleFactory.ARTICLE_CSV.path) {
            readAllWithHeaderAsSequence().map {
                org.jackie35er.dwh.oltp.domain.Article(
                    articleNr = 0,
                    supplier = suppliers.random(),
                    category = categories.random(),
                    name = it["name"]!!,
                    supplyUnit = org.jackie35er.dwh.oltp.testdata.ArticleFactory.units().random(),
                    price = it["price"]!!.toDouble(),
                    stock = it["stock"]!!.toInt(),
                    orderUnit = org.jackie35er.dwh.oltp.testdata.ArticleFactory.units().random(),
                    minStock = it["minStock"]!!.toInt(),
                    discontinued = it["discontinued"]!!.toBoolean(),
                )
            }.toList()
        }
    }
}