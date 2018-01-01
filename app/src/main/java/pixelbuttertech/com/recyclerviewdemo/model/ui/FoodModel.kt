package pixelbuttertech.com.recyclerviewdemo.model.ui

import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.model.data.Food

// TODO add attributes
data class FoodModel(private val food: Food) : ViewType {
    override fun getItemType() = ViewType.TYPE_FOOD
    fun getName() = food.name
    fun getDrawableId() = food.drawableId
    fun getDescription() = food.description
    fun getCost() = food.cost
}