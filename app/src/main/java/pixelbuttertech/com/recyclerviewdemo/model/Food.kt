package pixelbuttertech.com.recyclerviewdemo.model

import android.support.annotation.DrawableRes
import pixelbuttertech.com.recyclerviewdemo.R
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import java.util.*

data class Food(@DrawableRes val drawableId: Int = getRandomImage()) : ViewType {
    override fun getItemType() = ViewType.TYPE_FOOD
}

private val RANDOM = Random()

private fun getRandomImage() = when (RANDOM.nextInt(3)) {
    0 -> R.drawable.food_bread
    1 -> R.drawable.food_grapes
    2 -> R.drawable.food_milk
    3 -> R.drawable.food_peanut
    else -> R.drawable.food_peanut
}