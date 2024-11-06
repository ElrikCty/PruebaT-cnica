import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import com.example.pruebapractica.model.Animal
import com.example.pruebapractica.R

class MainActivityTest {

    private lateinit var animalList: MutableList<Animal> // Lista mutable de animales para pruebas

    @Before
    fun setup() {
        // Inicializa animalList con datos de ejemplo para realizar las pruebas
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
            )
        )
    }

    @Test
    fun testToggleFavoriteStatus() {
        val animalName = "León" // Nombre del animal al que se le cambiará el estado de favorito

        // Verifica que el estado inicial de favorito sea falso
        val animal = animalList.find { it.nombre == animalName }
        assertNotNull(animal) // Verifica que el animal exista en la lista
        assertFalse(animal!!.esFavorito) // Confirma que inicialmente no es favorito

        // Cambia el estado de favorito
        val result = toggleFavoriteStatus(animalName)
        assertTrue(result) // Verifica que retorne true (cambio exitoso)
        assertTrue(animal.esFavorito) // Ahora debe ser favorito (true)

        // Cambia el estado de favorito nuevamente para verificar que se revierte
        toggleFavoriteStatus(animalName)
        assertFalse(animal.esFavorito) // Ahora debe ser falso (no favorito)
    }


    // Cambia el estado de favorito de un animal dado su nombre y retorna true si tuvo éxito
    private fun toggleFavoriteStatus(animalName: String): Boolean {
        val animal = animalList.find { it.nombre == animalName }
        return if (animal != null) {
            animal.esFavorito = !animal.esFavorito // Cambia el estado a su opuesto
            true // Retorna true si el cambio fue exitoso
        } else {
            false // Retorna false si no se encontró el animal en la lista
        }
    }
}
