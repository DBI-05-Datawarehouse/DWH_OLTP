package org.jackie35er.dwh.oltp.testdata

import org.jackie35er.dwh.oltp.domain.Category

object CategorySupplier {

    fun createCategories() : List<org.jackie35er.dwh.oltp.domain.Category> {
        return listOf(
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Beverages",
                "light lunch items and beverages will be available for sale"
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Condiments",
                "A condiment is a preparation that is added to food, typically after cooking, to impart a specific flavor, to enhance the flavor, or to complement the dish"
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Confections",
                "A \"confection\" is \"confected\" from several different ingredients or elements. Most confections are sweet, but the word can also be used to refer to any finely worked piece of craftsmanship"
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Dairy Products",
                "Dairy products are the kinds of foods that are obtained primarily from or contain milk of mammals such as cattle, goats, sheep, etc. Dairy products include a variety of foods such as cheese, butter, yogurt, and many more."
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Grains/Cereals",
                "Grain is the harvested seed of grasses such as wheat, oats, rice, and corn. Other important grains include sorghum, millet, rye, and barley. Around the globe, grains, also called cereals, are the most important staple food. Humans get an average of 48 percent of their calories, or food energy, from grains"
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Meat/Poultry",
                "Poultry meat refers to the edible portion of any domesticated avian species, such as chicken, duck, turkey, geese, guinea fowl, and Japanese quail. Poultry meat has an important role in fulfilling the demand of high quality animal protein and food security"
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Produce",
                "Produce is a generalized term for many farm-produced crops, including fruits and vegetables (grains, oats, etc. are also sometimes considered produce). More specifically, the term produce often implies that the products are fresh and generally in the same state as where and when they were harvested."
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Seafood",
                "Seafood refers to any form related to sea life that is regarded as food by humans. It comprises edible aquatic animals but excludes mammals. In simple words, it includes both ocean creatures and freshwater creatures. It is significantly comprised of shellfish and fish"
            ),
            org.jackie35er.dwh.oltp.domain.Category(
                0,
                "Egg",
                "Eggs have a hard shell of calcium carbonate enclosing a liquid white, a single yolk (or an occasional double yolk)and an air cell. The white or albumen is a clear liquid that turns to an opaque white when cooked or beaten. The yolk is orange to yellow in color, and becomes pale yellow when cooked to a solid form."
            )

        )
    }
}