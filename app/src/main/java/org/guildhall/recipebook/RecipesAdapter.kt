package org.guildhall.recipebook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipesAdapter(private val _recipes:Array<Recipe>)
    : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)

        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return _recipes.count()
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(_recipes[position])
    }

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        private val appImage:ImageView = itemView.findViewById(R.id.image_view_recipe_icon)
        private val appTitle:TextView = itemView.findViewById(R.id.text_view_title)
        private val appDesc:TextView = itemView.findViewById(R.id.text_view_description)

        fun bind(recipe: Recipe)
        {
            appImage.setImageResource(recipe.image)
            appTitle.text = recipe.name
            appDesc.text = recipe.description
        }
    }
}