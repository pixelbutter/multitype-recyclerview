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
import pixelbuttertech.com.recyclerviewdemo.model.ui.ChefModel

class ChefDelegateAdapter(private val presenter: RestaurantContract.Presenter) : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chef, parent, false)
        return ChefViewHolder(view, presenter)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ChefViewHolder
        holder.bind(item as ChefModel)
    }

    private class ChefViewHolder(view: View, private val presenter: RestaurantContract.Presenter) : RecyclerView.ViewHolder(view) {
        private val chefName: TextView = view.findViewById(R.id.chefName)
        private val chefImage: ImageView = view.findViewById(R.id.chefImage)
        private val experience: TextView = view.findViewById(R.id.yearsOfExperience)
        private val pov: TextView = view.findViewById(R.id.chefPovValue)
        private val specialtyImage: ImageView = view.findViewById(R.id.chefSpecialtyImage)
        private val specialtyName: TextView = view.findViewById(R.id.chefSpecialtyDishValue)
        private val messageButton: View = view.findViewById(R.id.chefActionMessage)
        private val favoriteButton: ImageView = view.findViewById(R.id.chefActionFavorite)
        private val bookmarkButton: ImageView = view.findViewById(R.id.chefActionBookmark)

        fun bind(chefModel: ChefModel) {
            with(chefModel) {
                chefName.text = getName()
                chefImage.setImageResource(getDrawableId())
                chefImage.drawable.setColorFilter(ContextCompat.getColor(itemView.context, R.color.colorPrimary),
                        PorterDuff.Mode.DST_ATOP)
                experience.text = itemView.context.getString(R.string.chef_years_of_experience, getExperience())
                pov.text = getPointOfView()

                val specialtyDish = getSpecialtyDish()
                specialtyImage.setImageResource(specialtyDish.drawableId)
                specialtyName.text = specialtyDish.name

                messageButton.setOnClickListener { presenter.onMessageChef(this) }

                setFavoriteDrawable(chefModel.favorited)
                favoriteButton.setOnClickListener {
                    val favorited = !chefModel.favorited
                    setFavoriteDrawable(favorited)
                    presenter.onFavoriteChef(this, favorited)
                }

                setBookmarkDrawable(chefModel.bookmarked)
                bookmarkButton.setOnClickListener {
                    val bookmarked = !chefModel.bookmarked
                    setBookmarkDrawable(bookmarked)
                    presenter.onBookmarkChef(this, bookmarked)
                }
            }
            itemView.setOnClickListener { presenter.onChefSelected(chefModel.getName()) }
        }

        private fun setFavoriteDrawable(favorited: Boolean) {
            val context = itemView.context
            val drawable = if (favorited) {
                context.getDrawable(R.drawable.ic_favorite_filled)
            } else {
                context.getDrawable(R.drawable.ic_favorite_hollow)
            }
            favoriteButton.setImageDrawable(drawable)
        }

        private fun setBookmarkDrawable(bookmarked: Boolean) {
            val context = itemView.context
            val drawable = if (bookmarked) {
                context.getDrawable(R.drawable.ic_bookmark_filled)
            } else {
                context.getDrawable(R.drawable.ic_bookmark_hollow)
            }
            bookmarkButton.setImageDrawable(drawable)
        }
    }
}