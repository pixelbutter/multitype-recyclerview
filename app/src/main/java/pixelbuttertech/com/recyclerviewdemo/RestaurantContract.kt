package pixelbuttertech.com.recyclerviewdemo

import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.model.ui.ChefModel

interface RestaurantContract {

    interface View {
        var presenter: Presenter
        fun showItems(items: List<ViewType>)
        fun showFavoritedMessage(chefName: String, favorited: Boolean)
        fun showBookmarkedMessage(chefName: String, bookmarked: Boolean)
        fun showMessage(message: String)
        fun showMessageChefDialog(chefName: String)
    }

    interface Presenter {
        fun loadItems()

         // chef
        fun onChefSelected(name: String)
        fun onMessageChef(chef: ChefModel)
        fun onFavoriteChef(chef: ChefModel, favorited: Boolean)
        fun onBookmarkChef(chef: ChefModel, bookmarked: Boolean)

        // food
        fun onFoodClicked()
    }
}