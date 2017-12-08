package pixelbuttertech.com.recyclerviewdemo

import pixelbuttertech.com.recyclerviewdemo.common.ViewType

interface RestaurantContract {

    interface View {
        var presenter: Presenter

        fun showItems(items: List<ViewType>)

        fun showMessage(message: String)
    }

    interface Presenter {
        fun loadItems()

        fun onChefSelected(name: String)

        fun onFoodClicked()
    }
}