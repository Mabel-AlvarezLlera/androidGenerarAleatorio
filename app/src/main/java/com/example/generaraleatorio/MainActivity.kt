package com.example.generaraleatorio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // El botón al que voy a agregar un evento
        val botonGenerarAleatorio: Button = findViewById(R.id.buttonGenerar)
        // El textView dónde está el rango del aleatorio
        val textViewRangoAleatorio: EditText = findViewById(R.id.editTextNumero)

        // Agrego el evento de clic al botón
        botonGenerarAleatorio.setOnClickListener {
            // Método que genera el número aleatorio en el rango que indicamos en el textView
            if ((textViewRangoAleatorio.text.toString() == "") || (textViewRangoAleatorio.text.toString() == "0")) {
                // Si el textView está vacío o es 0 mostramos un mensaje
                val toast = Toast.makeText(this, getString(R.string.rango_incorrecto), Toast.LENGTH_SHORT)
                toast.show()
            }
            else {
                // Si no se genera el número
                generarAleatorio(textViewRangoAleatorio.text.toString())
            }
        }
        textViewRangoAleatorio.contentDescription = getString(R.string.campo_rango)
    }

    private fun generarAleatorio(numeroRangoString: String) {
        val numeroRangoInt: Int = numeroRangoString.toInt() // El número del rango a generar en entero

        val generarAleatorio = GenerarAleatorio(numeroRangoInt) // Objeto de la clase generarAleatorio

        // El textView donde se mostrará el aleatorio generado
        val textViewNumeroGenerado: TextView = findViewById(R.id.textViewNumero)
        // Generamos el número aleatorio y lo mostramos
        textViewNumeroGenerado.text = generarAleatorio.generar().toString()
    }
}