package com.example.pruebapractica.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebapractica.R
import com.example.pruebapractica.model.Animal
import com.example.pruebapractica.ui.detail.AnimalDetailActivity
import com.example.pruebapractica.utils.FavoritesManager

class MainActivity : AppCompatActivity() {
    // Lista de animales que se mostrará en la interfaz de usuario
    var animalList = listOf(
        Animal(
            nombre = "León",
            habitat = "Sabana",
            dieta = "Carnívoro",
            vida = "12 años",
            imageResId = R.drawable.lion,
            nombreCientifico = "Panthera leo",
            peso = "190 kg",
            velocidad = "80 km/h",
            datoCurioso = "El león es el único felino que vive en grupos llamados manadas."
        ),
        Animal(
            nombre = "Elefante",
            habitat = "Bosque",
            dieta = "Herbívoro",
            vida = "60 años",
            imageResId = R.drawable.elephant,
            nombreCientifico = "Loxodonta africana",
            peso = "6,000 kg",
            velocidad = "40 km/h",
            datoCurioso = "Los elefantes tienen una memoria excelente y pueden recordar lugares y personas."
        ),
        Animal(
            nombre = "Pingüino",
            habitat = "Antártida",
            dieta = "Carnívoro",
            vida = "20 años",
            imageResId = R.drawable.penguin,
            nombreCientifico = "Aptenodytes forsteri",
            peso = "35 kg",
            velocidad = "8 km/h en agua",
            datoCurioso = "Los pingüinos son aves que no pueden volar, pero son excelentes nadadores."
        ),
        Animal(
            nombre = "Canguro",
            habitat = "Australia",
            dieta = "Herbívoro",
            vida = "6 años",
            imageResId = R.drawable.kangaroo,
            nombreCientifico = "Macropus rufus",
            peso = "85 kg",
            velocidad = "70 km/h",
            datoCurioso = "Los canguros pueden saltar hasta 3 metros de altura en un solo salto."
        ),
        Animal(
            nombre = "Panda",
            habitat = "Bosque de bambú",
            dieta = "Herbívoro",
            vida = "20 años",
            imageResId = R.drawable.panda,
            nombreCientifico = "Ailuropoda melanoleuca",
            peso = "100 kg",
            velocidad = "30 km/h",
            datoCurioso = "Los pandas pasan hasta 14 horas al día comiendo bambú."
        ),
        Animal(
            nombre = "Tigre",
            habitat = "Selva tropical",
            dieta = "Carnívoro",
            vida = "15 años",
            imageResId = R.drawable.tiger,
            nombreCientifico = "Panthera tigris",
            peso = "220 kg",
            velocidad = "65 km/h",
            datoCurioso = "Cada tigre tiene un patrón único de rayas, similar a una huella digital."
        ),
        Animal(
            nombre = "Jirafa",
            habitat = "Sabana",
            dieta = "Herbívoro",
            vida = "25 años",
            imageResId = R.drawable.giraffe,
            nombreCientifico = "Giraffa camelopardalis",
            peso = "1,200 kg",
            velocidad = "60 km/h",
            datoCurioso = "Las jirafas tienen la lengua azul y pueden alcanzar hasta 50 cm de longitud."
        ),
        Animal(
            nombre = "Cebra",
            habitat = "Praderas",
            dieta = "Herbívoro",
            vida = "20 años",
            imageResId = R.drawable.zebra,
            nombreCientifico = "Equus quagga",
            peso = "300 kg",
            velocidad = "65 km/h",
            datoCurioso = "Las rayas de cada cebra son únicas y actúan como una huella digital."
        ),
        Animal(
            nombre = "Zorro",
            habitat = "Bosques",
            dieta = "Omnívoro",
            vida = "5 años",
            imageResId = R.drawable.fox,
            nombreCientifico = "Vulpes vulpes",
            peso = "6 kg",
            velocidad = "50 km/h",
            datoCurioso = "Los zorros tienen un excelente sentido del oído y pueden escuchar pequeños animales bajo tierra."
        ),
        Animal(
            nombre = "Lobo",
            habitat = "Bosques",
            dieta = "Carnívoro",
            vida = "10 años",
            imageResId = R.drawable.wolf,
            nombreCientifico = "Canis lupus",
            peso = "45 kg",
            velocidad = "60 km/h",
            datoCurioso = "Los lobos se comunican entre sí a través de aullidos que pueden escucharse a kilómetros de distancia."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        // Cargar favoritos desde SharedPreferences
        val favorites = FavoritesManager(this.applicationContext).loadFavorites()
        animalList.forEach { animal ->
            animal.esFavorito = favorites.contains(animal.nombre)
        }

        // Configuración del RecyclerView para mostrar la lista de animales
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AnimalAdapter(animalList,

            // Acción al hacer clic en un animal: abre la actividad de detalles
            onItemClick = { animal ->
                val intent = Intent(this, AnimalDetailActivity::class.java)
                intent.putExtra("animal", animal)
                startActivity(intent)
            },
            // Acción al hacer clic en el icono de favorito
            onFavoriteClick = {
                handleFavoriteClick()
            }
        )
        ViewCompat.setOnApplyWindowInsetsListener(recyclerView) { view, insets ->
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.systemBars()).top
            view.updatePadding(top = statusBarHeight)
            insets
        }

    }
    // Manejar la acción de guardar la lista de animales favoritos
    fun handleFavoriteClick() {
        val updatedFavorites = animalList.filter { it.esFavorito }.map { it.nombre }.toSet()
        FavoritesManager(
            context = this.applicationContext
        ).saveFavorites(updatedFavorites)
    }

}


