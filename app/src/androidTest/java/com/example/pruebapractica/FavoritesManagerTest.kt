package com.example.pruebapractica

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.pruebapractica.model.Animal
import com.example.pruebapractica.utils.FavoritesManager
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FavoritesManagerTest {

    private lateinit var favoritesManager: FavoritesManager // Instancia para manejar favoritos
    private lateinit var animalList: MutableList<Animal> // Lista mutable de animales para pruebas

    @Before
    fun setup() {

        val context = ApplicationProvider.getApplicationContext<Context>()
        favoritesManager = FavoritesManager(context)

        // Inicializa la lista de animales con datos de ejemplo
        animalList = mutableListOf(
            Animal(
                nombre = "León",
                habitat = "Sabana",
                dieta = "Carnívoro",
                vida = "12 años",
                imageResId = R.drawable.lion,
                nombreCientifico = "Panthera leo",
                peso = "190 kg",
                velocidad = "80 km/h",
                datoCurioso = "El león es el único felino que vive en grupos llamados manadas.",
                esFavorito = true // Este animal está marcado como favorito
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
                datoCurioso = "Los pingüinos son aves que no pueden volar, pero son excelentes nadadores.",
                esFavorito = false // Este animal no está marcado como favorito
            )
        )
    }

    @Test
    fun testSaveAndLoadFavorites() {
        // Crea un conjunto de nombres de animales favoritos
        val favorites = setOf("León", "Elefante")

        // Guarda los favoritos usando FavoritesManager
        favoritesManager.saveFavorites(favorites)

        // Carga los favoritos y verifica que coincidan con el conjunto guardado
        val loadedFavorites = favoritesManager.loadFavorites()
        assertEquals(favorites, loadedFavorites) // Compara los favoritos guardados con los cargados
    }

    @Test
    fun testHandleFavoriteClick() {
        // Simula el comportamiento de handleFavoriteClick guardando los favoritos actuales
        val favoritesToSave = animalList.filter { it.esFavorito }.map { it.nombre }.toSet()
        favoritesManager.saveFavorites(favoritesToSave)

        // Verifica que los favoritos guardados incluyan solo el animal marcado como favorito
        val loadedFavorites = favoritesManager.loadFavorites()
        assertEquals(setOf("León"), loadedFavorites) // Compara el resultado esperado con los favoritos cargados
    }
}

