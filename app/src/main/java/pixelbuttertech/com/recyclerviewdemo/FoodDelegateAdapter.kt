package pixelbuttertech.com.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_food.view.*
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.common.ViewTypeDelegateAdapter
import pixelbuttertech.com.recyclerviewdemo.model.ui.FoodModel

class FoodDelegateAdapter(private val presenter: RestaurantContract.Presenter) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view, presenter)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as FoodViewHolder
        holder.bind(item as FoodModel)
    }

    private class FoodViewHolder(view: View, private val presenter: RestaurantContract.Presenter) : RecyclerView.ViewHolder(view) {
        fun bind(food: FoodModel) {
            itemView.apply {
                foodName.text = food.getName()
                foodImage.setImageResource(food.getDrawableId())
                foodDescription.text = food.getDescription()
                foodPrice.text = "\$${food.getCost()}"
                setOnClickListener { presenter.onFoodClicked() }
            }
        }
    }
}