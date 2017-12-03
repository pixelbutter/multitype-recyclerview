package pixelbuttertech.com.recyclerviewdemo.model

interface ListItem {
    fun getItemType(): Int
    fun getToastMessage(): String

    companion object {
        const val TYPE_TEXT = 0
        const val TYPE_IMAGE = 1
    }
}