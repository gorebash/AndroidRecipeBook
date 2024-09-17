package org.guildhall.recipebook

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import org.guildhall.recipebook.R.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val view = findViewById<LinearLayout>(R.id.main)

        val intent = Intent(this, RecipesRecyclerActivity::class.java)
        intent.putExtra("category", "breakfast")
        //intent.putExtra("key", Parcelable) // parcelable type

        val b1 = view.findViewById<Button>(R.id.button_breakfast)
        b1.setOnClickListener { startActivity(intent) }
    }
}