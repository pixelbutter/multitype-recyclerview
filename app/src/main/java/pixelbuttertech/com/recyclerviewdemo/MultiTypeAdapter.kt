package pixelbuttertech.com.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import pixelbuttertech.com.recyclerviewdemo.model.CatImage
import pixelbuttertech.com.recyclerviewdemo.model.Item
import pixelbuttertech.com.recyclerviewdemo.model.ListItem

class MultiTypeAdapter(private val items: List<ListItem>, val listener: (ListItem) -> Unit) :
        RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder? {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            ListItem.TYPE_IMAGE -> {
                val view = inflater.inflate(R.layout.item_image, parent, false)
                return ImageViewHolder(view)
            }
            ListItem.TYPE_TEXT -> {
                val view = inflater.inflate(R.layout.item_basic_card, parent, false)
                return BasicViewHolder(view)
            }
        }
        return null
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].getItemType()

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }
}

class BasicViewHolder(itemView: View) : BaseViewHolder(itemView) {
    override fun bind(item: ListItem, listener: (item: ListItem) -> Unit): Unit = with(itemView) {
        val textView = findViewById<TextView>(R.id.basicCardText)
        (item as? Item)?.let {
            textView.text = it.title
            itemView.setOnClickListener { listener(item) }
        }
    }
}

class ImageViewHolder(imageCard: View) : BaseViewHolder(imageCard) {
    override fun bind(item: ListItem, listener: (item: ListItem) -> Unit) = with(itemView) {
        val imageView = findViewById<ImageView>(R.id.itemImage)
        imageView.setImageResource((item as CatImage).drawableId)
    }
}

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: ListItem, listener: (item: ListItem) -> Unit)
}