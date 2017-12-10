package pixelbuttertech.com.recyclerviewdemo.model

import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import java.util.*

data class Chef constructor(val name: String,
                            val yearsOfExperience: Int,
                            val pointOfView: String,
                            val specialtyDish: Food) : ViewType {

    override fun getItemType() = ViewType.TYPE_CHEF

    companion object {
        private val RANDOM = Random()

        fun newInstance(): Chef {
            return Chef(getRandomName(), getRandomExperience(), getRandomPoV(), Food.newInstance())
        }

        private fun getRandomName(): String {
            return "${FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.size)]} ${LAST_NAMES[RANDOM.nextInt(LAST_NAMES.size)]}"
        }

        private fun getRandomPoV() = POINT_OF_VIEW[RANDOM.nextInt(POINT_OF_VIEW.size)]

        private fun getRandomExperience() = RANDOM.nextInt(30)
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

private val POINT_OF_VIEW = listOf<String>(
        "Just add cheese to everything",
        "Strong independent chef who don't need no sous!",
        "Gluten-free, vegan, nut-free, low-calorie, low-fat, no-sugar recipes",
        "Local food and sustainability",
        "Gastronomy meets fast food",
        "With rice: 10/10"
)