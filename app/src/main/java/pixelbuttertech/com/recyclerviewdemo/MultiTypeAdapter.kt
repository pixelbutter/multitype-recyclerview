package pixelbuttertech.com.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pixelbuttertech.com.recyclerviewdemo.model.Item

class MultiTypeAdapter(private val items: List<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<MultiTypeAdapter.BasicViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MultiTypeAdapter.BasicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_basic_card, parent, false)
        return BasicViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MultiTypeAdapter.BasicViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    class BasicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
            val textView = findViewById<TextView>(R.id.basicCardText)
            textView.text = item.title
            setOnClickListener { listener(item) }
        }
    }
}