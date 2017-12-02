package pixelbuttertech.com.recyclerviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pixelbuttertech.com.recyclerviewdemo.model.Item

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = (1..100).map { Item("cat $it") }
        recyclerView.adapter = MultiTypeAdapter(items, { showCatToast(it)} )
    }

    private fun showCatToast(item: Item) {
        Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
    }
}
