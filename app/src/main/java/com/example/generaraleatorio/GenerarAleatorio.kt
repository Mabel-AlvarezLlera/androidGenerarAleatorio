package com.example.generaraleatorio

// Esta clase genera el aleatorio, tiene un atributo que es el número de rango del aleatorio
class GenerarAleatorio (private val numRango: Int) {

    // Función que devolverá el aleatorio en ese rango indicado
    fun generar(): Int {
        return (1..numRango).random()
    }
}