package pixelbuttertech.com.recyclerviewdemo.model

import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import java.util.*

data class Chef(val name: String = getRandomChef()) : ViewType {
    override fun getItemType() = ViewType.TYPE_CHEF
}

// todo consolidate data classes?
private val RANDOM = Random()

private fun getRandomChef(): String {
    return "${FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.size)]} ${LAST_NAMES[RANDOM.nextInt(LAST_NAMES.size)]}"
}

private val FIRST_NAMES = listOf<String>(
        "Ashley", "Jamie", "Leslie", "Chris", "Morgan", "Sam", "Liv",
        "Jordan", "Taylor", "Hayden", "Alex", "Kelly", "Ash"
)

private val LAST_NAMES = listOf<String>(
        "Lee", "Zhang", "Nguyen", "Garcia", "Gonzalez", "Harris", "Patel", "Novak", "Yadav", "Khan",
        "Smith", "Martin", "Brown", "Parker", "Miller", "Jackson", "Diaz", "Sato", "Kato", "Tanaka"
)