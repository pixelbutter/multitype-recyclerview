package pixelbuttertech.com.recyclerviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pixelbuttertech.com.recyclerviewdemo.common.ViewType

class RestaurantActivity : AppCompatActivity(), RestaurantContract.View {

    override lateinit var presenter: RestaurantContract.Presenter
    private lateinit var adapter: MultiTypeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)
        presenter = RestaurantPresenter(this)
        adapter = MultiTypeAdapter(presenter)
        recyclerView.adapter = adapter

        presenter.loadItems()
    }

    override fun showItems(items: List<ViewType>) {
        adapter.updateItems(items)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showFavoritedMessage(chefName: String, favorited: Boolean) {
        val message = if (favorited) {
            getString(R.string.chef_message_added_to_favorites, chefName)
        } else {
            getString(R.string.chef_message_removed_from_favorites, chefName)
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showBookmarkedMessage(chefName: String, bookmarked: Boolean) {
        val message = if (bookmarked) {
            getString(R.string.chef_message_added_to_bookmarks, chefName)
        } else {
            getString(R.string.chef_message_removed_from_bookmarks, chefName)
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessageChefDialog(chefName: String) {
        val fragment = MessageDialogFragment.newInstance(chefName)
        fragment.show(fragmentManager, TAG_MESSAGE_CHEF_DIALOG)
    }

    companion object {
        const val TAG_MESSAGE_CHEF_DIALOG = "tagMessageChefDialogFragment"
    }
}