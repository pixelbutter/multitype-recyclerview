package pixelbuttertech.com.recyclerviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import pixelbuttertech.com.recyclerviewdemo.model.Chef
import pixelbuttertech.com.recyclerviewdemo.model.Food

class MainActivity : AppCompatActivity(),
        FoodDelegateAdapter.ActionListener,
        ChefDelegateAdapter.ActionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = (1..100).map {
            if (it % 2 == 0) Chef() else Food()
        }
        recyclerView.adapter = MultiTypeAdapter(items, this, this)
    }

    override fun onChefSelected(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onFoodClicked() {
        Toast.makeText(this, "food clicked!", Toast.LENGTH_SHORT).show()
    }
}
