package pixelbuttertech.com.recyclerviewdemo.model

import android.support.annotation.DrawableRes
import pixelbuttertech.com.recyclerviewdemo.R
import java.util.*

data class CatImage(@DrawableRes val drawableId: Int = getRandomImage()) : ListItem {
    override fun getToastMessage() = drawableId.toString()
    override fun getItemType() = ListItem.TYPE_IMAGE
}

private val RANDOM = Random()

private fun getRandomImage() = when (RANDOM.nextInt(6)) {
    0 -> R.drawable.neko_conductor
    1 -> R.drawable.neko_kathmandu
    2 -> R.drawable.neko_ninja
    3 -> R.drawable.neko_pirate
    4 -> R.drawable.neko_pot_cat
    5 -> R.drawable.neko_tubbs
    else -> 0
}