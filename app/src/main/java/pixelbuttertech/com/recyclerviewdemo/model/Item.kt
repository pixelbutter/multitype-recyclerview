package pixelbuttertech.com.recyclerviewdemo.model

data class Item(val title: String): ListItem {
    override fun getToastMessage() = title
    override fun getItemType() = ListItem.TYPE_TEXT
}