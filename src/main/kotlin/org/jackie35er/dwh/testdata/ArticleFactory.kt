package org.jackie35er.dwh.testdata

import com.github.doyaaaaaken.kotlincsv.dsl.csvReader
import org.jackie35er.dwh.domain.Article
import org.jackie35er.dwh.domain.Category
import org.jackie35er.dwh.domain.Supplier

object ArticleFactory {
    private val ARTICLE_CSV = SupplierFactory::class.java.getResource("/mockaroo/Article.csv")

    private val units = {
        val units = mutableListOf<String>()
        for (i in 1..10) {
            units.add("Unit $i")
        }
        units
    }

    fun createArticles(suppliers: List<Supplier>, categories: List<Category>): List<Article> {
        return csvReader().open(ARTICLE_CSV.path) {
            readAllWithHeaderAsSequence().map {
                Article(
                    articleNr = 0,
                    supplier = suppliers.random(),
                    category = categories.random(),
                    name = it["name"]!!,
                    supplyUnit = units().random(),
                    price = it["price"]!!.toDouble(),
                    stock = it["stock"]!!.toInt(),
                    orderUnit = units().random(),
                    minStock = it["minStock"]!!.toInt(),
                    discontinued = it["discontinued"]!!.toBoolean(),
                )
            }.toList()
        }
    }
}