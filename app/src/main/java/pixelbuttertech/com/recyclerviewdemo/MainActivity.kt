package pixelbuttertech.com.recyclerviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pixelbuttertech.com.recyclerviewdemo.model.CatImage
import pixelbuttertech.com.recyclerviewdemo.model.Item
import pixelbuttertech.com.recyclerviewdemo.model.ListItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = (1..100).map {
            if (it % 2 == 0) Item("cat $it") else CatImage()
        }
        recyclerView.adapter = MultiTypeAdapter(items, { showCatToast(it)} )
    }

    private fun showCatToast(item: ListItem) {
        Toast.makeText(this, item.getToastMessage(), Toast.LENGTH_LONG).show()
    }
}
