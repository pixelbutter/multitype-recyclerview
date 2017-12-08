package pixelbuttertech.com.recyclerviewdemo

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.common.ViewTypeDelegateAdapter

class MultiTypeAdapter(presenter: RestaurantContract.Presenter) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        this.items = ArrayList(0)
        delegateAdapters.put(ViewType.TYPE_CHEF, ChefDelegateAdapter(presenter))
        delegateAdapters.put(ViewType.TYPE_FOOD, FoodDelegateAdapter(presenter))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = items[position].getItemType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        delegateAdapters.get(item.getItemType()).onBindViewHolder(holder, item)
    }

    fun updateItems(items: List<ViewType>) {
        this.items = items
        notifyDataSetChanged()
    }
}