package pixelbuttertech.com.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.common.ViewTypeDelegateAdapter
import pixelbuttertech.com.recyclerviewdemo.model.Chef

class ChefDelegateAdapter(val listener: ActionListener) : ViewTypeDelegateAdapter {

    interface ActionListener {
        fun onChefSelected(text: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chef, parent, false)
        return ChefViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ChefViewHolder
        holder.bind(item as Chef)
    }

    private class ChefViewHolder(view: View, private val listener: ActionListener) : RecyclerView.ViewHolder(view) {
        fun bind(chef: Chef) {
            val textView = itemView.findViewById<TextView>(R.id.chefText)
            textView.text = chef.name
            itemView.setOnClickListener { listener.onChefSelected(chef.name) }
        }
    }
}