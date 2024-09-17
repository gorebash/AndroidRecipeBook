package org.guildhall.recipebook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class RecipesRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_recipes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.recycler_view_recipes)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        //val bundle: Bundle? = intent.extras
        val category = intent.getStringExtra("category")
        val recipes = createRecipes()

        val view = findViewById<RecyclerView>(R.id.recycler_view_recipes)
        val adapter = RecipesAdapter(recipes.filter { it.category == category }.toTypedArray())
        view.adapter = adapter
    }

    private fun createRecipes () = arrayOf(
        Recipe(
            "Sausage, Egg and Cheese Stuffed Biscuits",
            "These aren't your grandma's biscuits!",
            R.drawable.sausage_buscuits,
            "breakfast"
        ),
        Recipe(
            "Ultimate Slow Cooker French Dip Sandwiches",
            "Slow Cooker French Dip Sandwiches are the ultimate sandwich made with your favorite beer with thick tender slices and an amazing crust!",
            R.drawable.ultimate_slow_cooker_french_dip_sandwiches,
            "lunch"
        ),
        Recipe(
            "Garlic Butter Steak Bites Recipe",
            "If you are a steak and potatoes kind of person, this is the ultimate recipe for you. Tender garlic butter steak bites with fragrant pan-fried potatoes infused with fresh herbs make this one of the best dinner ideas with steak tips ever.",
            R.drawable.steak_bites,
            "dinner"
        ),
        Recipe(
            "Honey Garlic Chicken",
            "20 minute Honey Garlic Chicken! Minimal ingredients, easy to prep, tastes amazing!!",
            R.drawable.honey_chicken,
            "dinner"
        ),
        Recipe(
            "Muffaletta Sandwich",
            "Italy",
            R.drawable.sandwich,
            "lunch"
        ),
        Recipe(
            "Black Pepper Chicken",
            "An easy black pepper chicken with juicy tender chicken, crisp vegetables and a rich savory black pepper",
            R.drawable.black_pepper_chicken,
            "dinner"
        ),
    )
}