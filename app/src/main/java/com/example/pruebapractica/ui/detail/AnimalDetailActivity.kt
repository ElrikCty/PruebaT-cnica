package com.example.pruebapractica.ui.detail

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebapractica.R
import com.example.pruebapractica.model.Animal

class AnimalDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_detail)

        // Asignar el objeto Animal
        val animal = intent.getParcelableExtra<Animal>("animal")

        // Binding de vistas
        val nombreTextView = findViewById<TextView>(R.id.nombreTextView)
        val habitatTextView = findViewById<TextView>(R.id.habitatTextView)
        val dietaTextView = findViewById<TextView>(R.id.dietaTextView)
        val vidaTextView = findViewById<TextView>(R.id.vidaTextView)
        val nombreCientificoTextView = findViewById<TextView>(R.id.nombreCientificoTextView)
        val pesoTextView = findViewById<TextView>(R.id.pesoTextView)
        val velocidadTextView = findViewById<TextView>(R.id.velocidadTextView)
        val datoCuriosoTextView = findViewById<TextView>(R.id.datoCuriosoTextView)
        val imageView = findViewById<ImageView>(R.id.animalImageView)

        // Asignar valores en UI
        animal?.let {
            nombreTextView.text = it.nombre
            habitatTextView.text = it.habitat
            dietaTextView.text = it.dieta
            vidaTextView.text = it.vida
            imageView.setImageResource(it.imageResId)
            nombreCientificoTextView.text = it.nombreCientifico
            pesoTextView.text = it.peso
            velocidadTextView.text = it.velocidad
            datoCuriosoTextView.text = it.datoCurioso

        }

        val returnButton: Button = findViewById(R.id.returnButton)

        // Click listener que muestra un Toast y vuelve a la main activity
        returnButton.setOnClickListener {
            Toast.makeText(this, "Volviendo a la lista", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}