package pixelbuttertech.com.recyclerviewdemo

import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.model.data.Chef

interface RestaurantContract {

    interface View {
        var presenter: Presenter
        fun showItems(items: List<ViewType>)
        fun showMessage(message: String)
        fun showMessageChefDialog(chefName: String)
    }

    interface Presenter {
        fun loadItems()

         // chef
        fun onChefSelected(name: String)
        fun onMessageChef(chef: Chef)
        fun onFavoriteChef(chef: Chef)
        fun onBookmarkChef(chef: Chef)

        // food
        fun onFoodClicked()
    }
}