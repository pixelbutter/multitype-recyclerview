package pixelbuttertech.com.recyclerviewdemo.model.data

import android.support.annotation.DrawableRes
import pixelbuttertech.com.recyclerviewdemo.R
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import java.util.*

data class Food private constructor(val name: String,
                                    @DrawableRes val drawableId: Int,
                                    val cost: Int = getRandomPrice(),
                                    val description: String = getRandomDescription()) : ViewType {

    override fun getItemType() = ViewType.TYPE_FOOD

    companion object {
        private val RANDOM = Random()

        fun newInstance() = when (RANDOM.nextInt(11)) {
            0 -> Food("Bento Box", R.drawable.food_bento)
            1 -> Food("Hamburger", R.drawable.food_burger)
            2 -> Food("Angel Food Cake", R.drawable.food_cake)
            3 -> Food("Fried Egg", R.drawable.food_egg)
            4 -> Food("Shabu Shabu", R.drawable.food_hotpot)
            5 -> Food("Seafood Paella", R.drawable.food_paella)
            6 -> Food("Buttermilk Pancakes", R.drawable.food_pancakes)
            7 -> Food("Tonkatsu Ramen", R.drawable.food_ramen)
            8 -> Food("Chef's Salad", R.drawable.food_salad)
            9 -> Food("Mom's Spaghetti", R.drawable.food_spaghetti)
            10 -> Food("Omakase", R.drawable.food_sushi)
            else -> Food("Bento Box", R.drawable.food_bento)
        }

        private fun getRandomDescription() = VEGGIE_IPSUM[RANDOM.nextInt(VEGGIE_IPSUM.size)]
        private fun getRandomPrice() = RANDOM.nextInt(100)
    }
}

private val VEGGIE_IPSUM = listOf<String>(
        "Veggies es bonus vobis, proinde vos postulo essum magis kohlrabi welsh onion daikon amaranth tatsoi tomatillo melon azuki bean garlic.",
        "Gumbo beet greens corn soko endive gumbo gourd. Parsley shallot courgette tatsoi pea sprouts fava bean collard greens dandelion okra wakame tomato. Dandelion cucumber earthnut pea peanut soko zucchini.",
        "Turnip greens yarrow ricebean rutabaga endive cauliflower sea lettuce kohlrabi amaranth water spinach avocado daikon napa cabbage asparagus winter purslane kale. Celery potato scallion desert raisin horseradish spinach carrot soko.",
        "Lotus root water spinach fennel kombu maize bamboo shoot green bean swiss chard seakale pumpkin onion chickpea gram corn pea.",
        "Nori grape silver beet broccoli kombu beet greens fava bean potato quandong celery. Bunya nuts black-eyed pea prairie turnip leek lentil turnip greens parsnip. Sea lettuce lettuce water chestnut eggplant.",
        "Celery quandong swiss chard chicory earthnut pea potato. Salsify taro catsear garlic gram celery bitterleaf wattle seed collard greens nori. Grape wattle seed kombu beetroot horseradish carrot squash brussels sprout chard."
)