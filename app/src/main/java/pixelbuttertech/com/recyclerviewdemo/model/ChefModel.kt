package pixelbuttertech.com.recyclerviewdemo.model

import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.model.data.Chef

data class ChefModel(val chef: Chef,
                     var bookmarked: Boolean = false) : ViewType {

    override fun getItemType() = ViewType.TYPE_CHEF
}