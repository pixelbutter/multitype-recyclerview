package pixelbuttertech.com.recyclerviewdemo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.common.ViewTypeDelegateAdapter
import pixelbuttertech.com.recyclerviewdemo.model.Chef

class ChefDelegateAdapter(private val presenter: RestaurantContract.Presenter) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chef, parent, false)
        return ChefViewHolder(view, presenter)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ChefViewHolder
        holder.bind(item as Chef)
    }

    private class ChefViewHolder(view: View, private val presenter: RestaurantContract.Presenter) : RecyclerView.ViewHolder(view) {
        fun bind(chef: Chef) {
            val chefName = itemView.findViewById<TextView>(R.id.chefName)
            val experience = itemView.findViewById<TextView>(R.id.yearsOfExperience)
            val pov = itemView.findViewById<TextView>(R.id.chefPovValue)
            val specialtyImage = itemView.findViewById<ImageView>(R.id.chefSpecialtyImage)
            val specialtyName = itemView.findViewById<TextView>(R.id.chefSpecialtyDishValue)

            with(chef) {
                chefName.text = name
                experience.text = itemView.context.getString(R.string.chef_years_of_experience, yearsOfExperience)
                pov.text = pointOfView
                specialtyImage.setImageResource(specialtyDish.drawableId)
                specialtyName.text = specialtyDish.name
            }
            itemView.setOnClickListener { presenter.onChefSelected(chef.name) }
        }
    }
}