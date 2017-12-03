package pixelbuttertech.com.recyclerviewdemo.common

interface ViewType {
    fun getItemType(): Int

    companion object {
        // todo move outside class?
        const val TYPE_CHEF = 0
        const val TYPE_FOOD = 1
    }
}