package pixelbuttertech.com.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.common.ViewTypeDelegateAdapter
import pixelbuttertech.com.recyclerviewdemo.model.Food

class FoodDelegateAdapter(private val listener: ActionListener) : ViewTypeDelegateAdapter {

    interface ActionListener {
        fun onFoodClicked()
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as FoodViewHolder
        holder.bind(item as Food)
    }

    private class FoodViewHolder(view: View, private val listener: ActionListener) : RecyclerView.ViewHolder(view) {
        fun bind(food: Food) {
            val imageView = itemView.findViewById<ImageView>(R.id.foodImage)
            imageView.setImageResource(food.drawableId)
            itemView.setOnClickListener { listener.onFoodClicked() }
        }
    }
}