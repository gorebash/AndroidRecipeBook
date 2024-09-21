package org.guildhall.recipebook

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.guildhall.recipebook.R.id
import org.guildhall.recipebook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val intent = Intent(this, RecipesRecyclerActivity::class.java)
        binding.buttonBreakfast.setOnClickListener {
            intent.putExtra("category", "breakfast")
            startActivity(intent)
        }

        binding.buttonLunch.setOnClickListener {
            intent.putExtra("category", "lunch")
            startActivity(intent)
        }

        binding.buttonDinner.setOnClickListener {
            intent.putExtra("category", "dinner")
            startActivity(intent)
        }
    }
}