package com.example.pruebapractica.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebapractica.R
import com.example.pruebapractica.model.Animal

import android.widget.ImageView

class AnimalAdapter(
    private val animals: List<Animal>,
    private val onItemClick: (Animal) -> Unit,
    private val onFavoriteClick: (Animal) -> Unit
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    inner class AnimalViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nombreTextView: TextView = view.findViewById(R.id.nombreAnimalTextView)
        private val habitatTextView: TextView = view.findViewById(R.id.habitatAnimalTextView)
        private val imageView: ImageView = view.findViewById(R.id.animalImageView)
        private val nombreCientifico: TextView = view.findViewById(R.id.nombreCientificoTextView)
        private val favoriteIcon: ImageView = view.findViewById(R.id.favoriteIcon)

        fun bind(animal: Animal) {
            nombreTextView.text = animal.nombre
            habitatTextView.text = animal.habitat
            imageView.setImageResource(animal.imageResId)
            nombreCientifico.text = animal.nombreCientifico
            imageView.contentDescription = "Imagen de ${animal.nombre}"


            itemView.setOnClickListener {
                onItemClick(animal)
            }

            favoriteIcon.setImageResource(
                if (animal.esFavorito) R.drawable.ic_favorite else R.drawable.ic_not_favorite
            )
            favoriteIcon.setOnClickListener {
                animal.esFavorito = !animal.esFavorito
                onFavoriteClick(animal)
                notifyItemChanged(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(animals[position])
    }

    override fun getItemCount() = animals.size
}
