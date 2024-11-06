package com.example.pruebapractica.utils

import android.content.Context
import android.content.SharedPreferences

// Clase para gestionar los favoritos de los animales usando SharedPreferences
class FavoritesManager(context: Context) {
    // Inicializa SharedPreferences con el nombre "animal_prefs" en modo privado
    private val sharedPrefs: SharedPreferences =
        context.getSharedPreferences("animal_prefs", Context.MODE_PRIVATE)

    // Función para guardar los nombres de los animales favoritos
    fun saveFavorites(favorites: Set<String>) {
        // Guarda el conjunto de favoritos en SharedPreferences con la clave "favoritos"
        sharedPrefs.edit().putStringSet("favoritos", favorites).apply()
    }

    // Función para cargar los nombres de los animales favoritos
    fun loadFavorites(): Set<String> {
        // Retorna el conjunto de favoritos almacenado en SharedPreferences o un conjunto vacío si no hay ninguno
        return sharedPrefs.getStringSet("favoritos", emptySet()) ?: emptySet()
    }
}

