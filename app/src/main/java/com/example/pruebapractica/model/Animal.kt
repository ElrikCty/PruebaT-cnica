package com.example.pruebapractica.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(
    val nombre: String,
    val habitat: String,
    val dieta: String,
    val vida: String,
    val imageResId: Int,  // Resource ID
    val nombreCientifico: String,
    val peso: String,
    val velocidad: String,
    val datoCurioso: String,
    var esFavorito: Boolean = false

): Parcelable