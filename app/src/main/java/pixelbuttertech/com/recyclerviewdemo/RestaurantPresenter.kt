package pixelbuttertech.com.recyclerviewdemo

import pixelbuttertech.com.recyclerviewdemo.model.ChefModel
import pixelbuttertech.com.recyclerviewdemo.model.data.Chef
import pixelbuttertech.com.recyclerviewdemo.model.data.Food

class RestaurantPresenter(val restaurantView: RestaurantContract.View)
    : RestaurantContract.Presenter {

    override fun loadItems() {
        val items = (1..100).map {
            if (it % 2 == 0) ChefModel(Chef.newInstance()) else Food.newInstance()
        }
        restaurantView.showItems(items)
    }

    override fun onChefSelected(name: String) {
        restaurantView.showMessage("$name is a chef!")
    }

    override fun onMessageChef(chef: Chef) {
        restaurantView.showMessageChefDialog(chef.name)
    }

    override fun onFavoriteChef(chef: Chef) {
        restaurantView.showMessage("${chef.name} added to favorites!")
    }

    override fun onBookmarkChef(chef: Chef) {
        restaurantView.showMessage("${chef.name} bookmarked")
    }

    override fun onFoodClicked() {
        restaurantView.showMessage("This is a food!")
    }

}