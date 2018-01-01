package pixelbuttertech.com.recyclerviewdemo

import pixelbuttertech.com.recyclerviewdemo.model.data.Chef
import pixelbuttertech.com.recyclerviewdemo.model.data.Food
import pixelbuttertech.com.recyclerviewdemo.model.ui.ChefModel
import pixelbuttertech.com.recyclerviewdemo.model.ui.FoodModel

class RestaurantPresenter(private val restaurantView: RestaurantContract.View)
    : RestaurantContract.Presenter {

    override fun loadItems() {
        val items = (1..100).map {
            if (it % 2 == 0) ChefModel(Chef.newInstance()) else FoodModel(Food.newInstance())
        }
        restaurantView.showItems(items)
    }

    override fun onChefSelected(name: String) {
        restaurantView.showMessage("$name is a chef!")
    }

    override fun onMessageChef(chef: ChefModel) {
        restaurantView.showMessageChefDialog(chef.getName())
    }

    override fun onFavoriteChef(chef: ChefModel, favorited: Boolean) {
        chef.favorited = favorited
        restaurantView.showFavoritedMessage(chef.getName(), favorited)
    }

    override fun onBookmarkChef(chef: ChefModel, bookmarked: Boolean) {
        chef.bookmarked = bookmarked
        restaurantView.showBookmarkedMessage(chef.getName(), bookmarked)
    }

    override fun onFoodClicked() {
        restaurantView.showMessage("This is a food!")
    }

}