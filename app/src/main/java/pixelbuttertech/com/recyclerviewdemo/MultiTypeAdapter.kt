package pixelbuttertech.com.recyclerviewdemo

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import pixelbuttertech.com.recyclerviewdemo.common.ViewType
import pixelbuttertech.com.recyclerviewdemo.common.ViewTypeDelegateAdapter

class MultiTypeAdapter(items: List<ViewType>, chefListener: ChefDelegateAdapter.ActionListener,
                       foodListener: FoodDelegateAdapter.ActionListener) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: List<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        this.items = ArrayList<ViewType>(items)
        delegateAdapters.put(ViewType.TYPE_CHEF, ChefDelegateAdapter(chefListener))
        delegateAdapters.put(ViewType.TYPE_FOOD, FoodDelegateAdapter(foodListener))
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
}