package pixelbuttertech.com.recyclerviewdemo.model.ui

import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.model.data.Chef

data class ChefModel(private val chef: Chef,
                     var bookmarked: Boolean = false,
                     var favorited: Boolean = false) : ViewType {
    override fun getItemType() = ViewType.TYPE_CHEF
    fun getName() = chef.name
    fun getDrawableId() = chef.drawableId
    fun getPointOfView() = chef.pointOfView
    fun getExperience() = chef.yearsOfExperience
    fun getSpecialtyDish() = chef.specialtyDish
}