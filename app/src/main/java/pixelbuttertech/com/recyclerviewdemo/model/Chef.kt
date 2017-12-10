package pixelbuttertech.com.recyclerviewdemo.model

import android.support.annotation.DrawableRes
import pixelbuttertech.com.recyclerviewdemo.R
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import java.util.*

data class Chef constructor(val name: String,
                            @DrawableRes val drawableId: Int,
                            val yearsOfExperience: Int,
                            val pointOfView: String,
                            val specialtyDish: Food) : ViewType {

    override fun getItemType() = ViewType.TYPE_CHEF

    companion object {
        private val RANDOM = Random()

        fun newInstance(): Chef {
            return Chef(getRandomName(),
                    getRandomChefDrawable(),
                    getRandomExperience(),
                    getRandomPoV(),
                    Food.newInstance())
        }

        private fun getRandomName(): String {
            return "${FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.size)]} ${LAST_NAMES[RANDOM.nextInt(LAST_NAMES.size)]}"
        }

        private fun getRandomPoV() = POINT_OF_VIEWS[RANDOM.nextInt(POINT_OF_VIEWS.size)]

        private fun getRandomExperience() = RANDOM.nextInt(30)

        private fun getRandomChefDrawable() = CHEF_DRAWABLE_IDS[RANDOM.nextInt(CHEF_DRAWABLE_IDS.size)]
    }
}

private val FIRST_NAMES = listOf<String>(
        "Ashley", "Jamie", "Leslie", "Chris", "Morgan", "Sam", "Liv",
        "Jordan", "Taylor", "Hayden", "Alex", "Kelly", "Ash"
)

private val LAST_NAMES = listOf<String>(
        "Lee", "Zhang", "Nguyen", "Garcia", "Gonzalez", "Harris", "Patel", "Novak", "Yadav", "Khan",
        "Smith", "Martin", "Brown", "Parker", "Miller", "Jackson", "Diaz", "Sato", "Kato", "Tanaka"
)

private val POINT_OF_VIEWS = listOf<String>(
        "Just add cheese to everything",
        "Strong independent chef who don't need no sous!",
        "Gluten-free, vegan, nut-free, low-calorie, low-fat, no-sugar recipes",
        "Local food and sustainability",
        "Gastronomy meets fast food",
        "With rice: 10/10"
)

private val CHEF_DRAWABLE_IDS = listOf<Int>(
        R.drawable.chef_cat,
        R.drawable.chef_person1,
        R.drawable.chef_person2,
        R.drawable.chef_person3,
        R.drawable.chef_person4
)