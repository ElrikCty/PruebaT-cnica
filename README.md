# Prueba Práctica

**Prueba Práctica** es una aplicación Android que muestra una lista de animales, donde los usuarios pueden marcar sus animales favoritos, y estos favoritos se guardan de manera persistente usando `SharedPreferences`.

## Contenidos
- [Características](#características)
- [Instalación](#instalación)
- [Uso](#uso)
- [Estructura del Código](#estructura-del-código)
- [Pruebas](#pruebas)

## Características

- **Lista de Animales**: Muestra una lista de animales con detalles básicos como el nombre, el hábitat y una imagen.
- **Vista Detallada**: Permite a los usuarios ver detalles adicionales de cada animal al hacer clic en él.
- **Animales Favoritos**: Los usuarios pueden marcar y desmarcar animales como favoritos.
- **Almacenamiento Persistente**: Los animales favoritos se guardan en `SharedPreferences` y se cargan automáticamente cuando la aplicación se vuelve a abrir.

## Instalación

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/ElrikCty/PruebaT-cnica.git
   
2. **Abrir en Android Studio**:

    Abre Android Studio, selecciona Open an Existing Project y elige el directorio clonado.

3.**Construir el Proyecto**:

    Permite que Gradle sincronice y construya el proyecto. Asegúrate de que no haya errores.

4.**Ejecutar la Aplicación**:

    Conecta un dispositivo Android o inicia un emulador, luego haz clic en Run.

## Uso

### Pantalla Principal
- **Ver Animales**: Muestra una lista desplazable de animales con imágenes y detalles básicos.
- **Marcar como Favorito**: Toca el icono de corazón para marcar o desmarcar un animal como favorito. Los favoritos se guardan automáticamente.

### Pantalla de Detalle
- **Detalles del Animal**: Muestra información detallada del animal seleccionado, incluyendo su nombre científico, peso promedio y otros datos curiosos.
- **Regresar a la Lista**: Usa el botón "Volver" para regresar a la pantalla principal.

## Estructura del Código

La aplicación está organizada de la siguiente manera:

- **MainActivity** (`MainActivity.kt`): Muestra la lista de animales y maneja la funcionalidad de marcar/desmarcar favoritos.
- **Detail Activity** (`AnimalDetailActivity.kt`): Muestra información detallada del animal seleccionado.
- **FavoritesManager** (`FavoritesManager.kt`): Administra la carga y el guardado de los favoritos utilizando `SharedPreferences`.
- **Adapter** (`AnimalAdapter.kt`): Administra la visualización de los elementos de animales en el `RecyclerView`.
- **Model** (`Animal.kt`): Clase de datos que representa la estructura de un animal.

### Principales Clases y Archivos
- `MainActivity.kt`: Pantalla principal que interactúa con `FavoritesManager` para gestionar los favoritos.
- `AnimalDetailActivity.kt`: Pantalla de detalle para mostrar la información de cada animal.
- `FavoritesManager.kt`: Clase que permite guardar y cargar los datos de favoritos en `SharedPreferences`.
- `AnimalAdapter.kt`: Adaptador para `RecyclerView` que muestra la lista de animales.
- `Animal.kt`: Modelo de datos para representar un `Animal`.

## Pruebas

### Pruebas Unitarias
Se han escrito pruebas unitarias para verificar funcionalidades centrales, como el cambio del estado de favorito de un animal.

Para ejecutar las pruebas unitarias:
1. Abre el archivo `MainActivityTest` en `src/test/java`.
2. Haz clic derecho sobre la clase y selecciona **Run 'MainActivityTest'**.

### Pruebas Instrumentadas
Las pruebas instrumentadas se utilizan para verificar funcionalidades específicas de Android, como el uso de `SharedPreferences`.

Para ejecutar las pruebas instrumentadas:
1. Abre el archivo `FavoritesManagerTest` en `src/androidTest/java`.
2. Haz clic derecho sobre la clase y selecciona **Run 'FavoritesManagerTest'**.
