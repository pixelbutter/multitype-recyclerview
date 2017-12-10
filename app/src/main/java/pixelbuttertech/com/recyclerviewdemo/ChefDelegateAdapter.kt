package pixelbuttertech.com.recyclerviewdemo

import android.graphics.PorterDuff
import android.support.v4.content.ContextCompat
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
        private val chefName: TextView = view.findViewById(R.id.chefName)
        private val chefImage: ImageView = view.findViewById(R.id.chefImage)
        private val experience: TextView = view.findViewById(R.id.yearsOfExperience)
        private val pov: TextView = view.findViewById(R.id.chefPovValue)
        private val specialtyImage: ImageView = view.findViewById<ImageView>(R.id.chefSpecialtyImage)
        private val specialtyName: TextView = view.findViewById<TextView>(R.id.chefSpecialtyDishValue)

        fun bind(chef: Chef) {
            with(chef) {
                chefName.text = name
                chefImage.setImageResource(drawableId)
                chefImage.drawable.setColorFilter(ContextCompat.getColor(itemView.context,
                        R.color.colorPrimary), PorterDuff.Mode.DST_ATOP)
                experience.text = itemView.context.getString(R.string.chef_years_of_experience, yearsOfExperience)
                pov.text = pointOfView
                specialtyImage.setImageResource(specialtyDish.drawableId)
                specialtyName.text = specialtyDish.name
            }
            itemView.setOnClickListener { presenter.onChefSelected(chef.name) }
        }
    }
}